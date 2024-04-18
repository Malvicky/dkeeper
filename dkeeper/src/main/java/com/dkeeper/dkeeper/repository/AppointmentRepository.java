package com.dkeeper.dkeeper.repository;
import com.dkeeper.dkeeper.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {}
