package com.othavio.appointment_scheduling.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.othavio.appointment_scheduling.exceptions.InvalidUUIDFormatException;
import com.othavio.appointment_scheduling.model.AppointmentSlot;
import com.othavio.appointment_scheduling.service.AppointmentSlotService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("v1/appointments")
@AllArgsConstructor
public class AppointmentController {

    @Autowired
    private final AppointmentSlotService appointmentSlotService;

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentSlot> getAppointmentById(@PathVariable String id) {
        try {
            UUID appointmentSlotId = UUID.fromString(id);
            AppointmentSlot appointmentSlot = appointmentSlotService.findById(appointmentSlotId);
            return ResponseEntity.ok(appointmentSlot);
        } catch (IllegalArgumentException e) {
            throw new InvalidUUIDFormatException();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointmentById(@PathVariable String id) {
        try {
            UUID appointmentSlotId = UUID.fromString(id);
            appointmentSlotService.deleteById(appointmentSlotId);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            throw new InvalidUUIDFormatException();
        }
    }
}