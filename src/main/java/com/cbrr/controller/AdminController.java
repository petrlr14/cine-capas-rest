package com.cbrr.controller;

import com.cbrr.domain.Movie;
import com.cbrr.domain.User;
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
@RequestMapping(path = "/admin", produces = "application/json")
@CrossOrigin(origins = "*")
public class AdminController extends BaseController {

    @Autowired
    MovieService movieService;
    @Autowired
    UserService userService;
    @Autowired
    JwtTokenProvider tokenProvider;

    /*Movie*/

    @PostMapping(path = {"/movie/create/", "/movie/create"})
    public ResponseEntity createMovie(@RequestBody Movie movie, HttpServletRequest request) {
        if (this.verifyToken(request, tokenProvider) != null) {
            return verifyToken(request, tokenProvider);
        }
        User createdBy = userService.getUserById(movie.getCreatedByUserID());
        User modifiedBy = userService.getUserById(movie.getModifiedByUserID());
        movie.setCreatedByUser(createdBy);
        movie.setModifiedByUser(modifiedBy);
        Movie movie1 = movieService.persist(movie);
        if (movie1 == null) {
            return new ResponseEntity<>(
                    new PersistMovie(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo crear la pelicula"),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        } else {
            return new ResponseEntity<>(
                    new PersistMovie(HttpStatus.CREATED, "Pelicula creada exitosamente"),
                    HttpStatus.CREATED
            );
        }
    }

    @PutMapping(path = {"/movie/edit/", "/movie/edit"})
    public ResponseEntity updateMovie(@RequestBody Movie movie, HttpServletRequest request) {
        if (this.verifyToken(request, tokenProvider) != null) {
            return verifyToken(request, tokenProvider);
        }
        User createdBy = userService.getUserById(movie.getCreatedByUserID());
        User modifiedBy = userService.getUserById(movie.getModifiedByUserID());
        movie.setCreatedByUser(createdBy);
        movie.setModifiedByUser(modifiedBy);
        Movie movie1 = movieService.persist(movie);
        if (movie1 == null) {
            return new ResponseEntity<>(
                    new PersistMovie(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo realizar la modificacion"),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        } else {
            String str;
            if (movie.getMovieId() != null) {
                str = "La pelicula se modifico correctamente";
            } else {
                str = "La pelicula se creo correctamente";
            }
            return new ResponseEntity<>(
                    new PersistMovie(HttpStatus.OK, str),
                    HttpStatus.OK
            );
        }
    }

    @DeleteMapping(path = {"/movie/delete/", "/movie/delete"})
    public ResponseEntity deleteMovie(@RequestParam("id") Long id, HttpServletRequest request) {
        if (this.verifyToken(request, tokenProvider) != null) {
            return verifyToken(request, tokenProvider);
        }
        movieService.delete(id);
        return new ResponseEntity<>(new PersistMovie(HttpStatus.ACCEPTED, "borrado"), HttpStatus.ACCEPTED);
    }

    @GetMapping(path = {"/user/", "/user"})
    public List<User> getAllUsers() {
        return userService.getAllByRol();
    }

    @PostMapping(path = {"/activate/", "/activate"})
    public ResponseEntity acitvateUser(@RequestParam Integer id) {
        userService.activeUser(id);
        return new ResponseEntity<>(userService.getUserById(Long.parseLong(id + "")), HttpStatus.OK);
    }

    @PostMapping(path = {"/deactivate/", "/deactivate"})
    public ResponseEntity deactivateUser(@RequestParam Integer id, @RequestParam String cause) {
        userService.deactivateUser(id, cause);
        return new ResponseEntity<>(userService.getUserById(Long.parseLong(id + "")), HttpStatus.OK);
    }

}
