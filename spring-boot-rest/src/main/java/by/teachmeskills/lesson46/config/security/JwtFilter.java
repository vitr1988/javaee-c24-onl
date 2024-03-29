package by.teachmeskills.lesson46.config.security;

import by.teachmeskills.lesson46.config.JwtHelper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private static final String BEARER_ = "Bearer ";

    private final JwtHelper jwtHelper;

    @Override
    @SneakyThrows
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (!StringUtils.isEmpty(header) && header.startsWith(BEARER_)) {
            String jwt = header.substring(BEARER_.length()).trim();
            final UserDetails userPrincipal = jwtHelper.getTokenClaims(jwt);
            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(userPrincipal.getUsername(), userPrincipal.getPassword(),
                            userPrincipal.getAuthorities())
            );
        }
        filterChain.doFilter(request, response);
    }
}
