package com.olimpusadonis.securesys.model.auth;


import lombok.Builder;

@Builder
public class TokenResponseDetail {

    private String AccessToken;
    private Double expiresIn;
    private String tokenType;
}
