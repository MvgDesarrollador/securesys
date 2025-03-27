package com.olimpusadonis.securesys.service.impl;

import com.olimpusadonis.securesys.model.UserDTO;
import com.olimpusadonis.securesys.model.auth.AuthRequest;
import com.olimpusadonis.securesys.model.ResponseDTO;
import com.olimpusadonis.securesys.model.auth.TokenResponseDetail;
import com.olimpusadonis.securesys.model.jpa.User;
import com.olimpusadonis.securesys.model.mapstruct.MapperTool;
import com.olimpusadonis.securesys.service.impl.tools.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MapperTool mapperTool;

    @Value("{expires.seconds}")
    private double expiresIn;

    private final String TYPE_TOKEN = "Bearer";

    public ResponseDTO authenticate(AuthRequest authRequest) {
        User user = userServiceImpl.findByUserName(authRequest.getUsername());

            UserDTO userDTO = mapperTool.userToDTO(user);

        if (!passwordEncoder.matches(authRequest.getPassword(), userDTO.getPasswordHash())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = tokenProvider.createToken(userDTO.getUsername(), userDTO.getListRole());
        TokenResponseDetail tokenResponse = TokenResponseDetail.builder()
                .AccessToken(token)
                .expiresIn(expiresIn)
                .tokenType(TYPE_TOKEN)
                .build();

        return ResponseDTO.builder().data(tokenResponse).build();
    }

}
