package com.cbrr.service.login;

import com.cbrr.domain.User;
import com.cbrr.repository.UserRepository;
import com.cbrr.responses.auth.LoginResponse;
import com.cbrr.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    JwtTokenProvider tokenProvider;

    @Override
    public LoginResponse performLogin(String username, String password) {
        User user = userRepository.findByUsernameAndPassWord(username, password/* passwordEncoder.encode(password) */);
        if (user != null) {
            if (user.getUserState()) {
                userRepository.loginUser(Integer.parseInt(user.getUserId() + ""));
                String token = tokenProvider.createToken(user);
                return new LoginResponse(HttpStatus.OK, "", token);
            } else {
                StringBuilder str = new StringBuilder();
                if (user.getUserBlockedState()) {
                    str.append(user.getBlockCause());
                } else {
                    if (user.getUserLogged()) {
                        str.append(
                                "Tienes sesión Activa en otro navegador. Solo pueder tener una sesión activa a la vez.");
                    } else {
                        str.append("Tu cuenta aún no ha sido verificada");
                    }
                }

                return new LoginResponse(HttpStatus.FORBIDDEN, str.toString(), "");
            }
        } else {
            return new LoginResponse(HttpStatus.UNAUTHORIZED, "Credenciales inválidas", "");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
