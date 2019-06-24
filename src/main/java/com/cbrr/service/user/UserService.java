package com.cbrr.service.user;

import com.cbrr.domain.User;
import com.cbrr.responses.auth.LoginResponse;
import com.cbrr.responses.auth.LogoutResponse;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

    LogoutResponse performLogout(HttpServletRequest request);

    LoginResponse performLogin(String username, String password);

    User getUserById(Long ID);

}
