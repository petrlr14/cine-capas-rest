package com.cbrr.controller;

import com.cbrr.domain.User;
import com.cbrr.request.ReservationForm;
import com.cbrr.security.JwtTokenProvider;
import com.cbrr.service.movie.MovieService;
import com.cbrr.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/client", produces = "application/json")
@CrossOrigin(origins = "*")
public class ClientController extends BaseController{

    @Autowired
    MovieService movieService;
    @Autowired
    UserService userService;
    @Autowired
    JwtTokenProvider tokenProvider;
    /*Movie*/

    @PostMapping(path = {"/reservation", "/reservation/"})
    public ResponseEntity reserva(@RequestBody ReservationForm reservationForm, HttpServletRequest request){
        if(this.verifyToken(request, tokenProvider)==null){
            return verifyToken(request, tokenProvider);
        }
        System.out.println(reservationForm.toString());
        return null;
    }

    /*@GetMapping(path = {"/reservation-info", "/reservation-info/"})
    public ResponseEntity get*/

    @GetMapping(path = {"/get-info", "/get-info/"})
    public ResponseEntity getUserInfo(HttpServletRequest request){
        if(this.verifyToken(request, tokenProvider)==null){
            return verifyToken(request, tokenProvider);
        }
        String username=this.tokenProvider.getUsername(this.tokenProvider.resolveToken(request));
        User user=(User) userService.loadUserByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}

