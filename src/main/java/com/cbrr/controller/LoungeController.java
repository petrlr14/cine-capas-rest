package com.cbrr.controller;

import com.cbrr.domain.Lounge;
import com.cbrr.service.lounge.LoungeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lounge")
@CrossOrigin(origins = "*")
public class LoungeController {

    @Autowired
    LoungeService loungeService;

    @GetMapping(path = {"/", ""})
    public List<Lounge> getAllLounge(){
        return loungeService.findAll();
    }

    @GetMapping(path = {"/one", "/one/"})
    public Lounge getById(@RequestParam Long id){
        return loungeService.findOne(id);
    }

}
