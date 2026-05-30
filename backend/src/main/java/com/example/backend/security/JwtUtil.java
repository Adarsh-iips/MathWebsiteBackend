package com.example.backend.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String jwtSecret;

    private Key getSigningKey() {

        return Keys.hmacShaKeyFor(
                jwtSecret.getBytes()
        );
    }

    public String generateToken(
            String username,
            String userType
    ) {

        return Jwts.builder()

                .setSubject(username)

                .claim(
                        "userType",
                        userType
                )

                .setIssuedAt(
                        new Date()
                )

                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 86400000
                        )
                )

                .signWith(
                        getSigningKey(),
                        SignatureAlgorithm.HS256
                )

                .compact();
    }

    public String extractUsername(
            String token
    ) {

        return Jwts.parserBuilder()

                .setSigningKey(
                        getSigningKey()
                )

                .build()

                .parseClaimsJws(token)

                .getBody()

                .getSubject();
    }

    public String extractUserType(
            String token
    ) {

        return Jwts.parserBuilder()

                .setSigningKey(
                        getSigningKey()
                )

                .build()

                .parseClaimsJws(token)

                .getBody()

                .get(
                        "userType",
                        String.class
                );
    }

    public boolean validateToken(
            String token
    ) {

        try {

            Jwts.parserBuilder()
                    .setSigningKey(
                            getSigningKey()
                    )
                    .build()
                    .parseClaimsJws(token);

            return true;

        } catch (Exception e) {

            return false;
        }
    }
}
