package com.cbrr.controller;

import com.cbrr.domain.Movie;
import com.cbrr.responses.BaseResponse;
import com.cbrr.service.movie.MovieService;
import com.cbrr.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = {"/movie"})
public class MovieController {

    @Autowired
    MovieService movieService;
    @Autowired
    UserService userService;

    @GetMapping(path = {"/", ""})
    public List<Movie> getAllMovies() {
        return movieService.getAll();
    }

    @GetMapping(path={"/movie/one/", "/movie/one"}, params = {"id"}, produces = "application/json")
    public BaseResponse getMovieById(@RequestParam Long id){
        Movie movie=movieService.findById(id);
        return movie==null?new BaseResponse():movie;
    }

}
