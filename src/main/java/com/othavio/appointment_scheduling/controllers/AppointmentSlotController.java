package com.othavio.appointment_scheduling.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.othavio.appointment_scheduling.dtos.appointment.AppointmentSlotDTO;
import com.othavio.appointment_scheduling.dtos.appointment.AppointmentSlotMapper;
import com.othavio.appointment_scheduling.dtos.appointment.CreateAppointmentSlotDTO;
import com.othavio.appointment_scheduling.exceptions.InvalidUUIDFormatException;
import com.othavio.appointment_scheduling.model.AppointmentSlot;
import com.othavio.appointment_scheduling.service.AppointmentSlotService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("v1/appointment-slots")
@AllArgsConstructor
public class AppointmentSlotController {

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

    @PostMapping
    public ResponseEntity<AppointmentSlotDTO> createAppointmentSlot(
            @RequestBody CreateAppointmentSlotDTO createAppointmentSlotDTO) {
        AppointmentSlot appointmentSlot = AppointmentSlotMapper.fromCreateDTOToModel(createAppointmentSlotDTO);
        appointmentSlotService.save(appointmentSlot);
        return ResponseEntity.status(HttpStatus.CREATED).body(AppointmentSlotMapper.toDTO(appointmentSlot));
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