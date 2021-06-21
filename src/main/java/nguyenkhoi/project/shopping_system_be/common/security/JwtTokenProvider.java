/*
 * Copyright (c) 2021. By Le Nguyen Khoi All Rights Reserved.
 * AdoptOpenJDK 11
 * Spring Boot 2.5.1
 * The Shopping System
 */

package nguyenkhoi.project.shopping_system_be.common.security;


import io.jsonwebtoken.*;
import nguyenkhoi.project.shopping_system_be.common.config.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.SignatureException;
import java.util.Date;

@Component
public class JwtTokenProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    private final AppProperties properties;

    public JwtTokenProvider(AppProperties properties) {
        this.properties = properties;
    }

    public String generateToken(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + properties.getAuth().getTokenExpirationMsec());

        return Jwts.builder()
                   .setSubject(userPrincipal.getUsername())
                   .setIssuedAt(new Date())
                   .setExpiration(expiryDate)
                   .signWith(SignatureAlgorithm.HS512, properties.getAuth().getTokenSecret())
                   .compact();
    }

    public String getPhoneFromJWT(String token) {
        Claims claims = Jwts.parser()
                            .setSigningKey(properties.getAuth().getTokenSecret())
                            .parseClaimsJws(token)
                            .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String authToken) throws SignatureException {
        try {
            Jwts.parser().setSigningKey(properties.getAuth().getTokenSecret()).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }
}
