package com.othavio.appointment_scheduling.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.othavio.appointment_scheduling.dtos.professional.HealthProfessionalDTO;
import com.othavio.appointment_scheduling.dtos.professional.HealthProfessionalMapper;
import com.othavio.appointment_scheduling.model.HealthProfessional;
import com.othavio.appointment_scheduling.service.HealthProfessionalService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@AllArgsConstructor
@RequestMapping("v1/health-professionals")
public class HealthProfessionalController {

        private final HealthProfessionalService healthProfessionalService;

        @GetMapping("")
        public ResponseEntity<List<HealthProfessionalDTO>> getHealthProfessionals() {

                List<HealthProfessional> healthProfessionals = healthProfessionalService.findAll();
                List<HealthProfessionalDTO> healthProfessionalsDTO = healthProfessionals.stream()
                                .map(HealthProfessionalMapper::toDTO).collect(Collectors.toList());

                return ResponseEntity.ok(healthProfessionalsDTO);
        }

        @PostMapping
        public ResponseEntity<HealthProfessionalDTO> createHealthProfessional(
                        @Valid @RequestBody HealthProfessionalDTO createHealthProfessionalDTO) {

                HealthProfessional healthProfessional = healthProfessionalService
                                .save(HealthProfessionalMapper.toModel(createHealthProfessionalDTO));
                HealthProfessionalDTO healthProfessionalDTO = HealthProfessionalMapper.toDTO(healthProfessional);
                return ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(healthProfessionalDTO);

        }

}
