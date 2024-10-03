package com.othavio.appointment_scheduling.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Pacient> getPacients() {
        return pacientService.findAll();
    }

}
