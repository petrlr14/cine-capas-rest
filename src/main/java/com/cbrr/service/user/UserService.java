package com.cbrr.service.user;

import com.cbrr.domain.User;
import com.cbrr.responses.auth.LoginResponse;
import com.cbrr.responses.auth.LogoutResponse;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

public interface UserService extends UserDetailsService {

    LogoutResponse performLogout(HttpServletRequest request);

    LoginResponse performLogin(String username, String password);

    User getUserById(Long ID);

    List<User> getAllByRol();

    List<User> getAll();

    Integer deactivateUser(int userId, String cause);

    Integer activeUser(int userId);

    User findUserByUsernameAndPassword(String username, String password);

    Integer register(String fname, String lname, String username, String password, Date bday, String address, String contry, String state, String province);

}
