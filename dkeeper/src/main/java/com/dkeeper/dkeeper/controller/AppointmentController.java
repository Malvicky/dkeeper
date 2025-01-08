package com.dkeeper.dkeeper.controller;
import com.dkeeper.dkeeper.dto.AppointmentDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

     @RestController
    @RequestMapping("/api/appointments")
    public class AppointmentController {

        private List<AppointmentDto> appointments = new ArrayList<>();

        @PostMapping
        public ResponseEntity<AppointmentDto> scheduleAppointment(@RequestBody AppointmentDto appointmentDto) {
            // Validate appointment details (e.g., check for overlapping times)
            if (isTimeSlotAvailable(appointmentDto.getEndTime())) {
                appointments.add(appointmentDto);
                return new ResponseEntity<>(appointmentDto, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.CONFLICT); // Time slot not available
            }
        }

        @GetMapping("/{codeId}")
        public ResponseEntity<AppointmentDto> getAppointment(@PathVariable String codeId) {
            return appointments.stream()
                    .filter(appointment -> appointment.getCodeId().equals(codeId))
                    .findFirst()
                    .map(appointment -> new ResponseEntity<>(appointment, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }

        @GetMapping
        public ResponseEntity<List<AppointmentDto>> getAllAppointments() {
            return new ResponseEntity<>(appointments, HttpStatus.OK);
        }

        @PutMapping("/{codeId}")
        public ResponseEntity<AppointmentDto> updateAppointment(@PathVariable String codeId, @RequestBody AppointmentDto updatedAppointment) {
            for (int i = 0; i < appointments.size(); i++) {
                if (appointments.get(i).getCodeId().equals(codeId)) {
                    // Validate updated appointment details
                    if (isTimeSlotAvailable(updatedAppointment.getEndTime())) {
                        appointments.set(i, updatedAppointment);
                        return new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>(HttpStatus.CONFLICT); // Time slot not available
                    }
                }
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        @DeleteMapping("/{codeId}")
        public ResponseEntity<Void> cancelAppointment(@PathVariable String codeId) {
            for (int i = 0; i < appointments.size(); i++) {
                if (appointments.get(i).getCodeId().equals(codeId)) {
                    appointments.remove(i);
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        @GetMapping("/total-cost")
        public ResponseEntity<BigDecimal> calculateTotalCost() {
            BigDecimal totalCost = appointments.stream()
                    .map(AppointmentDto::getPriceFinal)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            return new ResponseEntity<>(totalCost, HttpStatus.OK);
        }

        private boolean isTimeSlotAvailable(LocalDateTime endTime) {
            // Check if the time slot is available (this is a simple check; you may want to implement more complex logic)
            return appointments.stream()
                    .noneMatch(appointment -> appointment.getEndTime().isEqual(endTime));
        }
    }
