package com.cbrr.controller;

import com.cbrr.dto.StateDTO;
import com.cbrr.service.state.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/state", "/state/"})
@CrossOrigin(origins = "*")
public class StateController {

    @Autowired
    StateService stateService;

    @GetMapping(value = {"", "/"})
    List<StateDTO> getAllAsDTO(@RequestParam String id){
        return stateService.getStateAsDTO(id);
    }

}
