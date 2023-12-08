package com.dnanh01.backend.config;

import java.io.IOException;
import java.util.List;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * This class extends OncePerRequestFilter to perform JWT validation
 * on incoming requests. It extracts the JWT token from the request header,
 * validates its signature and structure, extracts claims, and sets up the
 * authentication in the Spring Security SecurityContextHolder. If the token is
 * invalid, it throws a BadCredentialsException. The filter then continues the
 * request processing by invoking the next filter in the chain.
 */
public class JwtValidator extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        // Extract the JWT token from the request header
        String jwt = request.getHeader(JwtConstant.JWT_HEADER);
        // Check if the JWT token is present
        if (jwt != null) {
            // Remove the "Bearer " prefix from the JWT token
            jwt = jwt.substring(7);

            try {
                // Create a secret key using the HMAC SHA algorithm with the secret key from
                // JwtConstant
                SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());
                // Parse the JWT token, validate its signature, and retrieve the claims
                Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
                // Extract the email and authorities claims from the JWT claims
                String email = String.valueOf(claims.get("email"));
                String authorties = String.valueOf(claims.get("authories"));
                // Convert the authorities claim into a list of GrantedAuthority objects
                List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList(authorties);
                // Create an authentication object using the email and authorities, set it in
                // the SecurityContext
                Authentication authentication = new UsernamePasswordAuthenticationToken(email, null, auths);

                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (Exception e) {
                // Throw a BadCredentialsException if there's an issue with the token
                throw new BadCredentialsException("Invalid token ... from jwt validator");
            }
        }
        // Continue the filter chain
        filterChain.doFilter(request, response);
    }
}
