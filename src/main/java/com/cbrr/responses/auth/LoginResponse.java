package com.cbrr.responses.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public @Data
class LoginResponse {

    private HttpStatus code;
    private String msg;
    private String token;

}