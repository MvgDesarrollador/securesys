package com.olimpusadonis.securesys.service.impl.tools;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class JwtTokenProvider {
    private final String SECRET_KEY = "mi_clave_secreta"; //from application.properties

    @Value("{expiration.time.value}")
    private long EXPIRATION_TIME; // from application.properties

    public String createToken(String username, List<String> listRole) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", listRole)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }
}
