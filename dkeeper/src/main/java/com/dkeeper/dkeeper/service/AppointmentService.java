package com.dkeeper.dkeeper.service;

import com.dkeeper.dkeeper.dto.AppointmentDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {

    private List<AppointmentDto> appointments = new ArrayList<>();

    public AppointmentDto scheduleAppointment(AppointmentDto appointmentDto) {
        appointments.add(appointmentDto);
        return appointmentDto;
    }

    public AppointmentDto getAppointment(String codeId) {
        return appointments.stream()
                .filter(appointment -> appointment.getCodeId().equals(codeId))
                .findFirst()
                .orElse(null);
    }

    public List<AppointmentDto> getAllAppointments() {
        return appointments;
    }

    public AppointmentDto updateAppointment(String codeId, AppointmentDto updatedAppointment) {
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getCodeId().equals(codeId)) {
                appointments.set(i, updatedAppointment);
                return updatedAppointment;
            }
        }
        return null;
    }

    public boolean cancelAppointment(String codeId) {
        return appointments.removeIf(appointment -> appointment.getCodeId().equals(codeId));
    }

    public BigDecimal calculateTotalCost() {
        return appointments.stream()
                .map(AppointmentDto::getPriceFinal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public boolean isTimeSlotAvailable(LocalDateTime endTime) {
        return appointments.stream()
                .noneMatch(appointment -> appointment.getEndTime().isEqual(endTime));
    }
}