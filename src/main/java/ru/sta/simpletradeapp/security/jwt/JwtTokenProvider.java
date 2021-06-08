package ru.sta.simpletradeapp.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secretKey;
    @Value("${jwt.expiration}")
    private Long validityMS;

    public String createToken(String username, String role){
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("role",role);
        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600*1000*validityMS);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256,"testKeyForSign")
                .compact();

    }
}
