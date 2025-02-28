package com.olimpusadonis.securesys.model.auth;

import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class AuthRequest {
    private String username;
    private String password;


}
