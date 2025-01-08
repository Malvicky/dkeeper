package com.dkeeper.dkeeper.service;

import com.dkeeper.dkeeper.dto.ScheduleDto;
import com.dkeeper.dkeeper.model.Schedule;
import com.dkeeper.dkeeper.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import  java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;


        // Create a new schedule
        public String createSchedule(ScheduleDto scheduleDto) {
            Schedule schedule = new Schedule();
            schedule.setCodeId(scheduleDto.getCodeId());
            schedule.setEmployeeId(scheduleDto.getEmployeeId());
            schedule.setLocation(scheduleDto.getLocation());
            scheduleRepository.save(schedule);
            return "Schedule created successfully";
        }

        // Update an existing schedule
        public String updateSchedule(Long id, ScheduleDto scheduleDto) {
            Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
            if (optionalSchedule.isPresent()) {
                Schedule schedule = optionalSchedule.get();
                schedule.setCodeId(scheduleDto.getCodeId());
                schedule.setEmployeeId(scheduleDto.getEmployeeId());
                schedule.setLocation(scheduleDto.getLocation());
                scheduleRepository.save(schedule);
                return "Schedule updated successfully";
            } else {
                return "Schedule not found";
            }
        }

        // Delete a schedule
        public String deleteSchedule(Long id) {
            if (scheduleRepository.existsById(id)) {
                scheduleRepository.deleteById(id);
                return "Schedule deleted successfully";
            } else {
                return "Schedule not found";
            }
        }

        // Get a schedule by ID
        public ScheduleDto getScheduleById(Long id) {
            Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
            if (optionalSchedule.isPresent()) {
                Schedule schedule = optionalSchedule.get();
                ScheduleDto scheduleDto = new ScheduleDto();
                scheduleDto.setCodeId(schedule.getCodeId());
                scheduleDto.setEmployeeId(schedule.getEmployeeId());
                scheduleDto.setLocation(schedule.getLocation());
                return scheduleDto;
            } else {
                return null; // or throw an exception if preferred
            }
        }

        // Get all schedules
        public List<ScheduleDto> getAllSchedules() {
            List<Schedule> schedules = scheduleRepository.findAll();
            return schedules.stream().map(schedule -> {
                ScheduleDto scheduleDto = new ScheduleDto();
                scheduleDto.setCodeId(schedule.getCodeId());
                scheduleDto.setEmployeeId(schedule.getEmployeeId());
                scheduleDto.setLocation(schedule.getLocation());
                return scheduleDto;
            }).collect(Collectors.toList());
        }
    }

