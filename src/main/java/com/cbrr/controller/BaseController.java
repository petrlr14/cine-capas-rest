package com.cbrr.controller;

import com.cbrr.responses.token.BadToken;
import com.cbrr.security.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

    ResponseEntity verifyToken(HttpServletRequest request, JwtTokenProvider tokenProvider){
        String token = tokenProvider.resolveToken(request);
        if (token == null) {
            return new ResponseEntity<>(new BadToken(HttpStatus.BAD_REQUEST, "Debes enviar un token"), HttpStatus.BAD_REQUEST);
        }
        if(!tokenProvider.validateToken(token)){
            return new ResponseEntity<>(new BadToken(HttpStatus.BAD_REQUEST, "Debes enviar un token valido"), HttpStatus.BAD_REQUEST);
        }
        return null;
    }

}
