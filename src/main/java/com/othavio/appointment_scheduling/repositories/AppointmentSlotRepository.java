package com.othavio.appointment_scheduling.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.othavio.appointment_scheduling.model.AppointmentSlot;

@Repository
public interface AppointmentSlotRepository extends JpaRepository<AppointmentSlot, UUID> {

    List<AppointmentSlot> findByHealthProfessionalId(UUID healthProfessionalId);

}
