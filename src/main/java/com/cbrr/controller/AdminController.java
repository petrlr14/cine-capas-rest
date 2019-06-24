package com.cbrr.controller;

import com.cbrr.domain.Movie;
import com.cbrr.domain.User;
import com.cbrr.responses.BaseResponse;
import com.cbrr.responses.auth.LogoutResponse;
import com.cbrr.responses.movie.PersistMovie;
import com.cbrr.responses.token.BadToken;
import com.cbrr.security.JwtTokenProvider;
import com.cbrr.service.movie.MovieService;
import com.cbrr.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/admin", produces = "application/json")
public class AdminController {

    @Autowired
    MovieService movieService;
    @Autowired
    UserService userService;
    @Autowired
    JwtTokenProvider tokenProvider;

        /*Movie*/

    @PostMapping(path = {"/movie/create", "/movie/create/"})
    public ResponseEntity createMovie(@RequestBody Movie movie, HttpServletRequest request){
        String token = tokenProvider.resolveToken(request);
        if (token == null) {
            return new ResponseEntity<>(new BadToken(HttpStatus.BAD_REQUEST, "Debes enviar un token"), HttpStatus.BAD_REQUEST);
        }
        if(!tokenProvider.validateToken(token)){
            return new ResponseEntity<>(new BadToken(HttpStatus.BAD_REQUEST, "Debes enviar un token valido"), HttpStatus.BAD_REQUEST);
        }
        User createdBy = userService.getUserById(movie.getCreatedByUserID());
        User modifiedBy = userService.getUserById(movie.getModifiedByUserID());
        movie.setCreatedByUser(createdBy);
        movie.setModifiedByUser(modifiedBy);
        Movie movie1=movieService.persist(movie);
        if (movie1==null) {
            return new ResponseEntity<>(
                    new PersistMovie(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo crear la pelicula"),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }else{
            return new ResponseEntity<>(
                    new PersistMovie(HttpStatus.CREATED, "Pelicula creada exitosamente"),
                    HttpStatus.CREATED
            );
        }
    }

    @PutMapping(path = {"/movie/edit/", "/movie/edit"})
    public ResponseEntity updateMovie(@RequestBody Movie movie){
        User createdBy = userService.getUserById(movie.getCreatedByUserID());
        User modifiedBy = userService.getUserById(movie.getModifiedByUserID());
        movie.setCreatedByUser(createdBy);
        movie.setModifiedByUser(modifiedBy);
        Movie movie1=movieService.persist(movie);
        if (movie1==null) {
            return new ResponseEntity<>(
                    new PersistMovie(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo realizar la modificacion"),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }else{
            String str;
            if(movie.getMovieId()!=null){
                str="La pelicula se modifico correctamente";
            }else{
                str="La pelicula se creo correctamente";
            }
            return new ResponseEntity<>(
                    new PersistMovie(HttpStatus.OK, str),
                    HttpStatus.OK
            );
        }
    }

    @DeleteMapping(path = {"/movie/delete/", "/movie/delete"})
    public ResponseEntity deleteMovie(@RequestParam("id") Long id){
        movieService.delete(id);
        return new ResponseEntity<>(new PersistMovie(HttpStatus.ACCEPTED, "borrado"), HttpStatus.ACCEPTED);
    }

}
