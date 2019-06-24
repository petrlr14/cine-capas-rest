package com.cbrr.controller;


import com.cbrr.request.LoginForm;
import com.cbrr.responses.auth.LoginResponse;
import com.cbrr.responses.auth.LogoutResponse;
import com.cbrr.service.login.LoginService;
import com.cbrr.service.logout.LogoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    LoginService loginService;
    @Autowired
    LogoutService logoutService;

    @PostMapping(path = {"/login", "/login/"})
    public ResponseEntity<LoginResponse> performLogin(@RequestBody LoginForm loginForm) {
        LoginResponse response = loginService.performLogin(loginForm.getUsername(), loginForm.getPassword());
        return new ResponseEntity<>(response, response.getCode());
    }

    @PostMapping(path = {"/logout", "/logout/"})
    public ResponseEntity<LogoutResponse> performLogout(HttpServletRequest request) {
        LogoutResponse response = logoutService.performLogout(request);
        return new ResponseEntity<>(response, response.getCode());
    }

}
