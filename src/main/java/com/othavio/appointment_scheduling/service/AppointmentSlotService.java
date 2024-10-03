package com.othavio.appointment_scheduling.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.othavio.appointment_scheduling.model.AppointmentSlot;
import com.othavio.appointment_scheduling.repositories.AppointmentSlotRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppointmentSlotService {

    private final AppointmentSlotRepository appointmentSlotRepository;

    public List<AppointmentSlot> findAll() {
        return appointmentSlotRepository.findAll();
    }

    public AppointmentSlot save(AppointmentSlot appointmentSlot) {
        return appointmentSlotRepository.save(appointmentSlot);
    }

    public void deleteById(UUID id) {
        appointmentSlotRepository.deleteById(id);
    }

    public AppointmentSlot findById(UUID id) {
        return appointmentSlotRepository.findById(id).orElse(null);
    }

}
