package com.cbrr.controller;


import com.cbrr.request.LoginForm;
import com.cbrr.responses.auth.LoginResponse;
import com.cbrr.responses.auth.LogoutResponse;
import com.cbrr.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping(path = {"/login", "/login/"})
    public ResponseEntity<LoginResponse> performLogin(@RequestBody LoginForm loginForm) {
        LoginResponse response = userService.performLogin(loginForm.getUsername(), loginForm.getPassword());
        return new ResponseEntity<>(response, response.getCode());
    }

    @PostMapping(path = {"/logout", "/logout/"})
    public ResponseEntity<LogoutResponse> performLogout(HttpServletRequest request) {
        LogoutResponse response = userService.performLogout(request);
        return new ResponseEntity<>(response, response.getCode());
    }

}
