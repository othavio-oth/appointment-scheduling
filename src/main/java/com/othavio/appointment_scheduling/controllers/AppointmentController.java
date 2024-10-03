package com.othavio.appointment_scheduling.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.othavio.appointment_scheduling.service.AppointmentSlotService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("v1/appointments")
@AllArgsConstructor
public class AppointmentController {

    @Autowired
    private final AppointmentSlotService appointmentSlotService;

}
