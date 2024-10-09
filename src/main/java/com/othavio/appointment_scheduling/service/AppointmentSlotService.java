package com.othavio.appointment_scheduling.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.othavio.appointment_scheduling.exceptions.NotFoundException;
import com.othavio.appointment_scheduling.model.AppointmentSlot;
import com.othavio.appointment_scheduling.model.HealthProfessional;
import com.othavio.appointment_scheduling.repositories.AppointmentSlotRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppointmentSlotService {

    @Autowired
    private final AppointmentSlotRepository appointmentSlotRepository;

    @Autowired
    private final HealthProfessionalService healthProfessionalService;

    public List<AppointmentSlot> findAll() {
        return appointmentSlotRepository.findAll();
    }

    public AppointmentSlot save(AppointmentSlot appointmentSlot) {
        HealthProfessional healthProfessional = healthProfessionalService
                .findById(appointmentSlot.getHealthProfessional().getId());
        appointmentSlot.setHealthProfessional(healthProfessional);
        return appointmentSlotRepository.save(appointmentSlot);
    }

    public AppointmentSlot findById(UUID id) {
        return appointmentSlotRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Appointment slot not found with id: " + id));
    }

    public void deleteById(UUID id) {
        AppointmentSlot appointmentSlot = findById(id);
        appointmentSlotRepository.delete(appointmentSlot);
    }

    public List<AppointmentSlot> findByHealthProfessionalId(UUID healthProfessionalId) {
        return appointmentSlotRepository.findByHealthProfessionalId(healthProfessionalId);
    }
}
