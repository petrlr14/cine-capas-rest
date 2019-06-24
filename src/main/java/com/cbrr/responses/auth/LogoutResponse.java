package com.cbrr.responses.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public @Data
class LogoutResponse {

    private HttpStatus code;
    private String msg;

}
