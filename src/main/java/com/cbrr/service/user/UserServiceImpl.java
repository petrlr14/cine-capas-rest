package com.cbrr.service.user;

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
import java.sql.Date;
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
        User user = userRepository.findByUsernameAndPassWord(username,  password);
        if (user != null) {
            if (user.getUserState()) {
                userRepository.loginUser(Integer.parseInt(user.getUserId() + ""));
                String token = tokenProvider.createToken(user);
                return new LoginResponse(HttpStatus.OK, "", "", token, user);
            } else {
                StringBuilder strMsg = new StringBuilder();
                StringBuilder strHeader = new StringBuilder();
                if (user.getUserBlockedState()) {
                    strMsg.append(user.getBlockCause());
                    strHeader.append("Cuenta bloquead");
                } else {
                    if (user.getUserLogged()) {
                        strMsg.append(
                                "Tienes sesión Activa en otro navegador. Solo pueder tener una sesión activa a la vez.");
                        strHeader.append("Sesion doble");
                    } else {
                        strMsg.append("Tu cuenta aún no ha sido por un administrador");
                        strHeader.append("Cuenta sin verifcar");
                    }
                }

                return new LoginResponse(HttpStatus.FORBIDDEN, strMsg.toString(), strHeader.toString(), "", null);
            }
        } else {
            return new LoginResponse(HttpStatus.UNAUTHORIZED, "La conbinacion de usuario y contraseña no es correcta", "Credenciales inválidas",  "", null);
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
    public Integer deactivateUser(int userId, String cause) {
        return userRepository.deactivateUser(userId, cause);
    }

    @Override
    public Integer activeUser(int userId) {
        return userRepository.activeUser(userId);
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassWord(username, password);
    }

    @Override
    public Integer register(String fname, String lname, String username, String password, Date bday, String address, String contry, String state, String province) {
        return userRepository.register(fname, lname, username, password, bday, address, contry, state, province);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
