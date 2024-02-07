package by.teachmeskills.lesson46.controller;

import by.teachmeskills.lesson46.config.JwtHelper;
import by.teachmeskills.lesson46.service.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    public static final String AUTH_REQUEST_MAPPING = "/auth";
//    private final UserDetailsService userDetailsService;
//    private final PasswordEncoder passwordEncoder;
    private final DaoAuthenticationProvider daoAuthenticationProvider;
    private final JwtHelper jwtHelper;

    @GetMapping(AUTH_REQUEST_MAPPING)
    public ResponseEntity<String> login(@RequestParam String login, @RequestParam String password,
                                        @RequestHeader(required = false, value = "X-Source") String source) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(login);
//        if (passwordEncoder.matches(password, userDetails.getPassword())) {
//            return ResponseEntity.ok(jwtHelper.generateToken(
//                    AuthController.class.getSimpleName(),
//                    source,
//                    (UserPrincipal) userDetails));
//        }
        try {
            UsernamePasswordAuthenticationToken authenticate = (UsernamePasswordAuthenticationToken) daoAuthenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(login, password));
//            SecurityContextHolder.getContext().setAuthentication(authenticate);
            return ResponseEntity.ok(jwtHelper.generateToken(
                    AuthController.class.getSimpleName(),
                    source,
                    authenticate));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }
}
