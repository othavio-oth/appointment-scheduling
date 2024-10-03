package com.othavio.appointment_scheduling.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.othavio.appointment_scheduling.model.HealthProfessional;
import com.othavio.appointment_scheduling.service.HealthProfessionalService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("v1/health-professionals")
public class HealthProfessionalController {

    private final HealthProfessionalService healthProfessionalService;

    @GetMapping("")
    public List<HealthProfessional> getHealthProfessionals() {
        return healthProfessionalService.findAll();
    }

}
