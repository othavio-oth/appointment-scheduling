package com.othavio.appointment_scheduling.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.othavio.appointment_scheduling.dtos.appointment.AppointmentDTO;
import com.othavio.appointment_scheduling.dtos.appointment.AppointmentMapper;
import com.othavio.appointment_scheduling.dtos.appointment.CreateAppointmentDTO;
import com.othavio.appointment_scheduling.model.Appointment;
import com.othavio.appointment_scheduling.service.AppointmentService;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("v1/appointments")
@AllArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentDTO> bookAppointment(@RequestBody CreateAppointmentDTO createAppointmentDTO) {

        Appointment appointment = appointmentService.save(AppointmentMapper.fromCreateDTOToModel(createAppointmentDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(AppointmentMapper.toDTO(appointment));
    }

}
