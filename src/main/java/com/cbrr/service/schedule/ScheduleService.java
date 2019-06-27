package com.cbrr.service.schedule;

import com.cbrr.domain.Schedule;

import java.util.List;

public interface ScheduleService {

    List<Schedule> findAll();
    Schedule findOneById(Long id);

}
