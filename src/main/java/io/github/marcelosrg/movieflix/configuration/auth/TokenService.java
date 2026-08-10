package io.github.marcelosrg.movieflix.configuration.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.github.marcelosrg.movieflix.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Component
public class TokenService {
    @Value("${movieflix.security.secret}")
    private String secret;

    public String generateToken(User user) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withSubject(user.getEmail())
                .withClaim("userId", user.getId().toString())
                .withClaim("name", user.getName())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .withIssuer("API - Movieflix")
                .sign(algorithm);
    }

    public Optional<JWTUserData> tokenValidation(String token) {

        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            DecodedJWT jwt = JWT.require(algorithm)
                    .build()
                    .verify(token);

            UUID userId = UUID.fromString(jwt.getClaim("userId").asString());

            return Optional.of(JWTUserData
                    .builder()
                    .id(userId)
                    .name(jwt.getClaim("name").asString())
                    .email(jwt.getSubject())
                    .build()
            );

        }catch (JWTVerificationException e){
            return Optional.empty();
        }

    }


}
