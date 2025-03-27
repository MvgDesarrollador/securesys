package com.olimpusadonis.securesys.config;
import com.olimpusadonis.securesys.config.tools.MyAuthenticationToken;
import com.olimpusadonis.securesys.model.UserDTO;
import com.olimpusadonis.securesys.model.jpa.User;
import com.olimpusadonis.securesys.service.impl.UserServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.olimpusadonis.securesys.model.mapstruct.MapperTool;

public class JwtAuthenticationFilter extends OncePerRequestFilter{
    private final String SECRET_KEY = "mi_clave_secreta";

    @Autowired
    private UserServiceImpl userServiceImpl;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);

            try {
                Claims claims = Jwts.parser()
                        .setSigningKey(SECRET_KEY)
                        .parseClaimsJws(token)
                        .getBody();

                String username = claims.getSubject();
                User userDetails = userServiceImpl.findByUserName(username);
                UserDTO userDTO = userServiceImpl.mapToDTO(userDetails);

                MyAuthenticationToken authentication = new MyAuthenticationToken(userDTO, null, userDTO.getRoles());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
