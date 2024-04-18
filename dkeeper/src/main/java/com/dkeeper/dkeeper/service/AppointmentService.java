package com.dkeeper.dkeeper.service;

import com.dkeeper.dkeeper.dto.AppointmentDto;
import com.dkeeper.dkeeper.model.Appointment;
import com.dkeeper.dkeeper.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    public String addAppointment(AppointmentDto load){
        Appointment appointment = new Appointment();
        appointment.setCodeId(load.getCodeId());
        appointment.setClientID(load.getClientID());
        appointment.setClientName(load.getClientName());
        appointment.setClientContact(load.getClientContact());
        appointment.setEndTime(load.getEndTime());
        appointment.setPriceFinal("Appointment Testing");
        appointmentRepository.save(appointment);
        return"Working on it ";

    }
}
