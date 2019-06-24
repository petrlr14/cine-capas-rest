package com.cbrr.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class LoginForm {

    private String username;
    private String password;
}