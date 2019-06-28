package com.cbrr.controller;

import com.cbrr.domain.Function;
import com.cbrr.dto.FunctionDTO;
import com.cbrr.service.function.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = {"/function/", "/function"})
@CrossOrigin(origins = "*")
public class FunctionController {

    @Autowired
    FunctionService functionService;

    @GetMapping(path = {"/", ""})
    public List<Function> getAllFunctions() {
        return functionService.getAllFunctions();
    }

    @GetMapping(path = {"/one", "/one/"})
    public Function getFunction(@RequestParam Long id) {
        return functionService.getFunction(id);
    }

    @GetMapping(path = {"/movieId", "/movieId/"})
    public List<FunctionDTO> getFunctionsById(@RequestParam Long id) {
        return functionService.getFunctionByMovieId(id);
    }

}
