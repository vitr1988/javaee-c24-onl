package by.teachmeskills.lesson46.config;

import by.teachmeskills.lesson46.config.security.JwtFilter;
import by.teachmeskills.lesson46.entity.RoleEnum;
import by.teachmeskills.lesson46.service.AuthenticationHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.stream.Collectors;

import static by.teachmeskills.lesson46.controller.AuthController.AUTH_REQUEST_MAPPING;
import static by.teachmeskills.lesson46.service.Authorities.ADMIN;
import static by.teachmeskills.lesson46.service.Authorities.USER;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    private final AuthenticationHandler authenticationHandler;

    private final JwtFilter jwtFilter;

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/css/*/style.css", "/webjars/**", "/images/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .exceptionHandling().authenticationEntryPoint(new Http403ForbiddenEntryPoint())
                .and()
                .authorizeRequests()
                .antMatchers("/", AUTH_REQUEST_MAPPING).permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/api/users/*").hasAnyAuthority(ADMIN, USER)
//                .antMatchers("/api/users/*").hasAnyRole("ROLE_" + ADMIN)
//                .antMatchers("/api/users/*").hasAnyRole("ROLE_" + ADMIN, "ROLE_" + USER)
                .antMatchers("/api/**").authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .formLogin()
//                    .loginPage("/users/login")
//                .httpBasic()
                .and()
                .addFilterAfter(jwtFilter, AnonymousAuthenticationFilter.class)
//                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .logout()
//                .logout(logout -> logout
//                        .logoutUrl("/my/logout")
//                        .logoutSuccessUrl("/my/index")
////                        .logoutSuccessHandler(authenticationHandler)
//                        .invalidateHttpSession(true)
//                        .addLogoutHandler(authenticationHandler)
//                        .deleteCookies("JSESSIONID")
//                )
//                .addLogoutHandler(authenticationHandler)
        ;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public List<RoleEnum> userRights() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .map(RoleEnum::valueOf)
                .collect(Collectors.toList());
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public UsernamePasswordAuthenticationToken user() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UsernamePasswordAuthenticationToken) authentication;
    }
}


