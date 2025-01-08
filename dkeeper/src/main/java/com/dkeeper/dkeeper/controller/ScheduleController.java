package com.dkeeper.dkeeper.controller;
import com.dkeeper.dkeeper.dto.ScheduleDto;
import com.dkeeper.dkeeper.model.Schedule;
import com.dkeeper.dkeeper.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class ScheduleController{

    private final ScheduleService scheduleService;

        // Endpoint to create a new schedule
        @PostMapping
        public ResponseEntity<String> createSchedule(@RequestBody ScheduleDto scheduleDto) {
            String response = scheduleService.createSchedule(scheduleDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }

        // Endpoint to update an existing schedule
        @PutMapping("/{id}")
        public ResponseEntity<String> updateSchedule(@PathVariable Long id, @RequestBody ScheduleDto scheduleDto) {
            String response = scheduleService.updateSchedule(id, scheduleDto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        // Endpoint to delete a schedule
        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteSchedule(@PathVariable Long id) {
            String response = scheduleService.deleteSchedule(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        // Endpoint to get a schedule by ID
        @GetMapping("/{id}")
        public ResponseEntity<ScheduleDto> getScheduleById(@PathVariable Long id) {
            ScheduleDto scheduleDto = scheduleService.getScheduleById(id);
            if (scheduleDto != null) {
                return new ResponseEntity<>(scheduleDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        // Endpoint to get all schedules
        @GetMapping
        public ResponseEntity<List<ScheduleDto>> getAllSchedules() {
            List<ScheduleDto> schedules = scheduleService.getAllSchedules();
            return new ResponseEntity<>(schedules, HttpStatus.OK);
        }
    }
