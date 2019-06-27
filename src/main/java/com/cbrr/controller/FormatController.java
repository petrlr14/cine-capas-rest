package com.cbrr.controller;


import com.cbrr.domain.MovieFormat;
import com.cbrr.service.movieFormat.MovieFormatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("format")
@CrossOrigin(origins = "*")
public class FormatController {

    @Autowired
    MovieFormatService movieFormatService;

    @GetMapping(path = {"/", ""})
    public List<MovieFormat> getAll(){
        return movieFormatService.findAll();
    }

    @GetMapping(path={"/one", "/one/"})
    public MovieFormat getById(@RequestParam Long id){
        return movieFormatService.findOneMovieFormat(id);
    }

}
