package com.cbrr.service.logout;

import com.cbrr.repository.UserRepository;
import com.cbrr.responses.auth.LogoutResponse;
import com.cbrr.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LogoutServiceImpl implements LogoutService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtTokenProvider tokenProvider;

    @Override
    public LogoutResponse performLogout(HttpServletRequest request) {
        String token = tokenProvider.resolveToken(request);
        if (token == null) {
            return new LogoutResponse(HttpStatus.BAD_REQUEST, "Necesitas un token para realizar esta operación");
        }
        String username = tokenProvider.getUsername(token);
        if (username != null) {
            userRepository.logOutUser(username);
            return new LogoutResponse(HttpStatus.OK, "Bye");
        }
        return new LogoutResponse(HttpStatus.BAD_REQUEST, "Token invalido");
    }

}
