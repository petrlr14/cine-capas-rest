package com.cbrr.controller;

import com.cbrr.domain.Schedule;
import com.cbrr.service.schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("schedule")
@CrossOrigin(origins = "*")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @GetMapping(path = {"/id", "/id/"})
    public Schedule getById(@RequestParam Long id) {
        return scheduleService.findOneById(id);
    }

}
