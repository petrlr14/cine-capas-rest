package com.cbrr.service.schedule;

import com.cbrr.domain.Schedule;
import com.cbrr.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Override
    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule findOneById(Long id) {
        return scheduleRepository.findById(id).orElse(new Schedule());
    }
}
