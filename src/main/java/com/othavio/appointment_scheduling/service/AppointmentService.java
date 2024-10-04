package com.othavio.appointment_scheduling.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.othavio.appointment_scheduling.exceptions.NotFoundException;
import com.othavio.appointment_scheduling.model.Appointment;
import com.othavio.appointment_scheduling.model.AppointmentSlot;
import com.othavio.appointment_scheduling.model.Pacient;
import com.othavio.appointment_scheduling.repositories.AppointmentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppointmentService {

    @Autowired
    private final AppointmentRepository appointmentRepository;

    @Autowired
    private final AppointmentSlotService appointmentSlotService;

    @Autowired
    private final PacientService pacientService;

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public Appointment save(Appointment appointment) {
        Pacient pacient = pacientService.findById(appointment.getPacient().getId());
        appointment.setPacient(pacient);

        AppointmentSlot appointmentSlot = appointmentSlotService
                .findById(appointment.getAppointmentSlot().getId());
        appointment.setAppointmentSlot(appointmentSlot);

        return appointmentRepository.save(appointment);
    }

    public Appointment findById(UUID id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Appointment not found with id: " + id));

        return appointment;
    }
}
