package com.cbrr.service.user;

import com.cbrr.domain.User;
import com.cbrr.responses.auth.LoginResponse;
import com.cbrr.responses.auth.LogoutResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;

public interface UserService extends UserDetailsService {

    LogoutResponse performLogout(HttpServletRequest request);

    LoginResponse performLogin(String username, String password);

    User getUserById(Long ID);

}
