package com.example.court_reserve.config;

import com.auth0.jwt.JWT;
import com.example.court_reserve.entity.User;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TokenService {
    @Value("${court.reserve.security.secret}")
    private String secret;


    public String generateToken(User user){
        Algorithm algorithm=Algorithm.HMAC256(secret);
        return JWT.create()
                .withSubject(user.getEmail())
                .withClaim("userId",user.getId())
                .withClaim("name",user.getName())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuer("API CourtReserve")
                .sign(algorithm);
    }
}
