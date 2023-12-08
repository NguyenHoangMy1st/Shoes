package com.dnanh01.backend.config;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtProvider {
    // Create a secret key using the HMAC SHA algorithm with the secret key from
    // JwtConstant
    SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());

    // Method to generate a JWT token based on the provided Authentication object
    public String generateToken(Authentication auth) {
        // Build the JWT token with issued date, expiration date, and email claim from
        // the Authentication object
        String jwt = Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + 86000000))
                .claim("email", auth.getName())
                .signWith(key).compact();
        System.out.println();
        return jwt;
    }

    // Method to extract the email claim from a given JWT token
    public String getEmailFromToken(String jwt) {
        jwt = jwt.substring(7);// Remove the "Bearer " prefix from the JWT string
        // Parse the JWT token, validate its signature, and retrieve the claims
        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
        // Extract and return the email claim from the JWT claims
        String email = String.valueOf(claims.get("email"));
        return email;
    }
}
