package com.othavio.appointment_scheduling.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.othavio.appointment_scheduling.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {

}
