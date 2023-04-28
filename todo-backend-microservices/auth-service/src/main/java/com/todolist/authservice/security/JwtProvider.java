package com.todolist.authservice.security;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtProvider {
    
    @Value("${access.token.secret}")
    private String ACCESS_TOKEN_SECRET;

    @Value("${access.token.validity-seconds}")
    private long ACCESS_TOKEN_VALIDITY_SECONDS;

    public String createToken(String name, String email, Collection<? extends GrantedAuthority> collection){

        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000L;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String,Object> extraInfo = new HashMap<>();
        extraInfo.put("name", name);
        extraInfo.put("email",email);
        extraInfo.put("roles",collection);

        return Jwts.builder()
            .setSubject(email)
            .setExpiration(expirationDate)
            .addClaims(extraInfo)
            .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
            .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
            .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
            .build()
            .parseClaimsJws(token);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    public String getUserEmail(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    
            String email = claims.getSubject();

            return email;
    }
}
