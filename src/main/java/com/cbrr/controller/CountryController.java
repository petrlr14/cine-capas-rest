package com.cbrr.controller;

import com.cbrr.domain.Country;
import com.cbrr.service.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = {"/country"})
@CrossOrigin(origins = "*")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping(path = {"/", ""})
    public List<Country> getAll(){
        return countryService.getAll();
    }

}
