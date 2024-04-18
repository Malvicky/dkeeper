package com.dkeeper.dkeeper.service;

import com.dkeeper.dkeeper.dto.ScheduleDto;
import com.dkeeper.dkeeper.model.Schedule;
import com.dkeeper.dkeeper.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
 public String addSchedule(ScheduleDto load){
     Schedule schedule = new Schedule();
     schedule.setCodeId(load.getCodeId());
     schedule.setEmployeeId(load.getEmployeeId());
     schedule.setLocation(load.getLocation());
     scheduleRepository.save(schedule);
     return "good to go!";
 }
}
