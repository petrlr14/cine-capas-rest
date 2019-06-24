package com.cbrr.service.login;

import com.cbrr.responses.auth.LoginResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface LoginService extends UserDetailsService {

    LoginResponse performLogin(String username, String password);

}

