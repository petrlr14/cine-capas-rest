package com.cbrr.controller;


import com.cbrr.domain.User;
import com.cbrr.request.LoginForm;
import com.cbrr.request.SignUpForm;
import com.cbrr.responses.auth.LoginResponse;
import com.cbrr.responses.auth.LogoutResponse;
import com.cbrr.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

@RestController
@CrossOrigin(origins = "*")
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

    @GetMapping(path = {"/check", "/check/"})
    public ResponseEntity checkIfExist(@RequestParam String username, @RequestParam String password){
        User user=userService.findUserByUsernameAndPassword(username, password);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(path = {"/register", "/register/"})
    public ResponseEntity register(@RequestBody SignUpForm form){
        Date date=Date.valueOf(form.getBirthday());
        Integer response=userService.register(form.getFirstName(), form.getLastName(), form.getUsername(), form.getPassword(), date, form.getAddress(), form.getCountry(), form.getState(), form.getProvince());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
