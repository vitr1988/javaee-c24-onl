package by.teachmeskills.lesson46.config;

import by.teachmeskills.lesson46.entity.RoleEnum;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Component
public class JwtHelper {

    /**
     * Наименование поля JWT, где сохранена информация об идентификаторе токена, по которому сохранена
     * информация об операторе в кэше
     */
    private static final String TOKEN_CLAIM = "token";

    /**
     * Наименование поля JWT, где сохранена информация о правах доступа оператора
     */
    private static final String PRIVILEGE_CLAIM = "privilege";

    /**
     * Наименование поля JWT, где сохранена информация об источнике, от имени которого идут запросы к АРМ
     */
    private static final String SOURCE_CLAIM = "source";

    /**
     * Секция заголовка в JWT
     */
    private static final JWSHeader JWT_HEADER = new JWSHeader(JWSAlgorithm.HS256);

    private final JWSSigner jwtSigner;
    private final JWSVerifier jwsVerifier;
    private final Duration expiration;

    public JwtHelper(@Value("${jwt.secret}") String secret, @Value("${jwt.expiration}") Duration expiration) throws JOSEException {
        // Create HMAC signer
        this.jwtSigner = new MACSigner(secret);
        this.jwsVerifier = new MACVerifier(secret);
        this.expiration = expiration;
    }

    @SneakyThrows
    public String generateToken(String issuer, @Nullable String xSource, Authentication userInfo) {
        final Pair<Date, Date> issueAndExpirationTimes = getIssueAndExpirationTimes();
        // Prepare JWT with claims set
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .issuer(issuer)
                .subject(userInfo.getName())
                .claim(TOKEN_CLAIM, UUID.randomUUID().toString())
                .claim(PRIVILEGE_CLAIM, userInfo.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList())
                )
                .claim(SOURCE_CLAIM, Objects.toString(xSource, ""))
                .issueTime(issueAndExpirationTimes.getLeft())
                .expirationTime(issueAndExpirationTimes.getRight())
                .build();

        SignedJWT signedJWT = new SignedJWT(JWT_HEADER, claimsSet);

        // Apply the HMAC protection
        signedJWT.sign(jwtSigner);

        // Serialize to compact form, produces something like that (jwt sample is below)
        // eyJhbGciOiJIUzI1NiJ9.SGVsbG8sIHdvcmxkIQ.onO9Ihudz3WkiauDO2Uhyuz0Y18UASXlSc1eS0NkWyA
        return signedJWT.serialize();
    }

    /**
     * Получение информации о токене из JWT
     *
     * @param token JWT
     * @return информация из токена, содержащая идентификатор токена в кэше, набор прав доступа и источник вызывающей системы
     * @throws JOSEException
     */
    @Nullable
    public UserDetails getTokenClaims(String token) throws JOSEException {
        final JWTClaimsSet jwtClaims;
        try {
            final SignedJWT decodedJWT = SignedJWT.parse(token);
            if (decodedJWT.verify(jwsVerifier) && isValid(jwtClaims = decodedJWT.getJWTClaimsSet())) {
                String userName = decodedJWT.getJWTClaimsSet().getSubject();
                final Stream<RoleEnum>userRights = this.<List<String>>getClaim(jwtClaims, PRIVILEGE_CLAIM)
                        .map(list -> list.stream().map(RoleEnum::valueOf))
                        .orElse(Stream.empty());
                return new User(userName, StringUtils.EMPTY, userRights.map(RoleEnum::name)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList())
                );
            }
        } catch (ParseException pe) {
            log.error("Invalid token {}", token, pe);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private <T> Optional<T> getClaim(JWTClaimsSet jwtClaims, String claim) {
        return Optional.ofNullable((T) jwtClaims.getClaim(claim));
    }

    private Pair<Date, Date> getIssueAndExpirationTimes() {
        Instant issuedAt = Instant.now().truncatedTo(ChronoUnit.MILLIS);
        Instant expirationAt = issuedAt.plus(expiration);
        return Pair.of(Date.from(issuedAt), Date.from(expirationAt));
    }

    public boolean isValid(JWTClaimsSet jwtClaims) {
        Date referenceTime = new Date();
        Date expirationTime = jwtClaims.getExpirationTime();
        Date notBeforeTime = jwtClaims.getNotBeforeTime();
        boolean expired = expirationTime != null && expirationTime.before(referenceTime);
        boolean yetValid = notBeforeTime == null || notBeforeTime.before(referenceTime);
        return !expired && yetValid;
    }
}

