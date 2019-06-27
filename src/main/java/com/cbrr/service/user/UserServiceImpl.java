package com.cbrr.service.user;

import com.cbrr.domain.Rol;
import com.cbrr.domain.User;
import com.cbrr.repository.RolRepository;
import com.cbrr.repository.UserRepository;
import com.cbrr.responses.auth.LoginResponse;
import com.cbrr.responses.auth.LogoutResponse;
import com.cbrr.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService, UserService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    JwtTokenProvider tokenProvider;
    @Autowired
    RolRepository rolRepository;

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

    @Override
    public LoginResponse performLogin(String username, String password) {
        User user = userRepository.findByUsernameAndPassWord(username, password/* passwordEncoder.encode(password) */);
        if (user != null) {
            if (user.getUserState()) {
                userRepository.loginUser(Integer.parseInt(user.getUserId() + ""));
                String token = tokenProvider.createToken(user);
                return new LoginResponse(HttpStatus.OK, "", token, user);
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

                return new LoginResponse(HttpStatus.FORBIDDEN, str.toString(), "", null);
            }
        } else {
            return new LoginResponse(HttpStatus.UNAUTHORIZED, "Credenciales inválidas", "", null);
        }
    }

    @Override
    public User getUserById(Long ID) {
        return userRepository.findById(ID).orElse(null);
    }

    @Override
    public List<User> getAllByRol() {
        return userRepository.findAllByRolId(rolRepository.getRolByRolAk("CLI"));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
