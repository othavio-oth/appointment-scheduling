package com.othavio.appointment_scheduling.controllers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.othavio.appointment_scheduling.dtos.pacient.PacientDTO;
import com.othavio.appointment_scheduling.dtos.pacient.PacientMapper;
import com.othavio.appointment_scheduling.model.Pacient;
import com.othavio.appointment_scheduling.service.PacientService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("v1/pacients")
@AllArgsConstructor
public class PacientController {

    @Autowired
    private final PacientService pacientService;

    @GetMapping("")
    public ResponseEntity<List<PacientDTO>> getPacients() {
        try {
            List<Pacient> pacients = pacientService.findAll();
            List<PacientDTO> pacientDTOs = pacients.stream()
                    .map(PacientMapper::toDTO)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(pacientDTOs);

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @PostMapping("")
    public ResponseEntity<PacientDTO> createPacient(@RequestBody PacientDTO pacientDTO) {
        try {
            Pacient pacient = pacientService.save(PacientMapper.toModel(pacientDTO));
            PacientDTO createdPacientDTO = PacientMapper.toDTO(pacient);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(createdPacientDTO);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacientDTO> getPacientById(@PathVariable UUID id) {
        try {
            Pacient pacient = pacientService.findById(id);
            PacientDTO pacientDTO = PacientMapper.toDTO(pacient);
            return ResponseEntity.ok(pacientDTO);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

}
