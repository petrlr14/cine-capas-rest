package com.cbrr.responses.auth;

import com.cbrr.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public @Data
class LoginResponse {

    private HttpStatus code;
    private String msg;
    private String token;
    private User user;
}