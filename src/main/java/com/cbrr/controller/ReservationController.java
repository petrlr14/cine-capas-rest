package com.cbrr.controller;

import com.cbrr.dto.MovieReservationDTO;
import com.cbrr.request.ReservationForm;
import com.cbrr.service.reservation.MovieReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@CrossOrigin(origins = "*")
public class ReservationController {

    @Autowired
    MovieReservationService movieReservationService;

    @GetMapping(value = {"", "/"})
    public List<MovieReservationDTO> getAllById(@RequestParam Long id){
        return movieReservationService.getReservationsByUser(id);
    }

    @PostMapping(value = {"/save", "/save/"})
    public ResponseEntity save(@RequestBody ReservationForm reservation, @RequestParam Long id){
        return new ResponseEntity<>(movieReservationService.insertReservation(reservation, id), HttpStatus.OK);
    }

}
