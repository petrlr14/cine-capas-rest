package com.cbrr.controller;

import com.cbrr.domain.Movie;
import com.cbrr.domain.User;
import com.cbrr.request.ReservationForm;
import com.cbrr.responses.BaseResponse;
import com.cbrr.responses.movie.PersistMovie;
import com.cbrr.security.JwtTokenProvider;
import com.cbrr.service.movie.MovieService;
import com.cbrr.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/client", produces = "application/json")
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
        if(this.verifyToken(request, tokenProvider)!=null){
            return verifyToken(request, tokenProvider);
        }
        System.out.println(reservationForm.toString());
        return null;
    }

}

