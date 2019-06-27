package com.cbrr.controller;

import com.cbrr.domain.*;
import com.cbrr.responses.function.FunctionDTO;
import com.cbrr.service.function.FunctionService;
import com.cbrr.service.lounge.LoungeService;
import com.cbrr.service.movie.MovieService;
import com.cbrr.service.movieFormat.MovieFormatService;
import com.cbrr.service.schedule.ScheduleService;
import com.cbrr.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = {"/function/", "/function"})
@CrossOrigin(origins = "*")
public class FunctionController {

    @Autowired
    FunctionService functionService;

    @Autowired
    MovieService movieService;

    @Autowired
    UserService userService;

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    MovieFormatService movieFormatService;

    @Autowired
    LoungeService loungeService;

    @GetMapping(path = {"/", ""})
    public List<Function> getAllFunctions() {
        return functionService.getAllFunctions();
    }

    @GetMapping(path = {"/one", "/one/"})
    public Function getFunction(@RequestParam Long id) {
        return functionService.getFunction(id);
    }

    @GetMapping(path = {"/movieId", "/movieId/"})
    public List<Function> getFunctionsById(@RequestParam Long id){
        return functionService.getFunctionByMovieId(id);
    }

}
