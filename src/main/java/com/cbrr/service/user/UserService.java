package com.cbrr.service.user;

import com.cbrr.domain.Rol;
import com.cbrr.domain.User;
import com.cbrr.responses.auth.LoginResponse;
import com.cbrr.responses.auth.LogoutResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService extends UserDetailsService {

    LogoutResponse performLogout(HttpServletRequest request);

    LoginResponse performLogin(String username, String password);

    User getUserById(Long ID);

    List<User> getAllByRol();

    List<User> getAll();

}
