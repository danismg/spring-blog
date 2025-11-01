package com.fastcampus.blog.service;

import com.fastcampus.blog.properties.SecretProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    @Autowired
    private SecretProperties secretProperties;


    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    public SecretKey getSignKey(){
        // maknaya dilakukan disini
        byte[] keyBytes = Decoders.BASE64.decode(secretProperties.getJwtSecretKey());
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private String createToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .claims(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String extractUsername(String jwt) {
        Claims claims = getClaims(jwt);
        return claims.getSubject();
    }

    private Claims getClaims(String jwt){
        return Jwts.parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(jwt)
                .getPayload();
    }

    public boolean isExpired(String jwt){
        Claims claims = getClaims(jwt);
        return claims.getExpiration()
                .before(Date.from(Instant.now()));
    }



}
