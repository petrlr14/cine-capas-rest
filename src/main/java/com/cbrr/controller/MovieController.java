package com.cbrr.controller;

import com.cbrr.domain.Movie;
import com.cbrr.responses.BaseResponse;
import com.cbrr.service.movie.MovieService;
import com.cbrr.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = {"/movie"})
@CrossOrigin(origins = "*")
public class MovieController{

    @Autowired
    MovieService movieService;
    @Autowired
    UserService userService;

    @GetMapping(path = {"/", ""})
    public List<Movie> getAllMovies() {
        return movieService.getAll();
    }

    @GetMapping(path={"/active", "active"})
    public List<Movie> getAllMoviesActive(){
        return movieService.getAllActive();
    }

    @GetMapping(path={"/one/", "/one"}, params = {"id"}, produces = "application/json")
    public BaseResponse getMovieById(@RequestParam Long id) {
        Movie movie=movieService.findById(id);
        return movie==null?new BaseResponse():movie;
    }
}
