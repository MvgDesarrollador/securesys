package com.olimpusadonis.securesys.controller;

import com.olimpusadonis.securesys.model.auth.AuthRequest;
import com.olimpusadonis.securesys.model.ResponseDTO;
import com.olimpusadonis.securesys.service.impl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/auth")
public class AuthController {

    @Autowired
    private AuthServiceImpl authServiceImpl;

    @PostMapping
    public ResponseEntity<ResponseDTO> login(@RequestBody AuthRequest authRequest) {
        ResponseDTO responseDTO = authServiceImpl.authenticate(authRequest);
        return ResponseEntity.ok(responseDTO);
    }
}
