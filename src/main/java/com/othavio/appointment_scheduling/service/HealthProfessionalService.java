package com.othavio.appointment_scheduling.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.othavio.appointment_scheduling.exceptions.NotFoundException;
import com.othavio.appointment_scheduling.model.HealthProfessional;
import com.othavio.appointment_scheduling.repositories.HealthProfessionalRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HealthProfessionalService {

    private final HealthProfessionalRepository healthProfessionalRepository;

    public List<HealthProfessional> findAll() {
        return healthProfessionalRepository.findAll();
    }

    public HealthProfessional save(HealthProfessional healthProfessional) {
        return healthProfessionalRepository.save(healthProfessional);
    }

    public void deleteById(UUID id) {
        HealthProfessional healthProfessional = findById(id);
        healthProfessionalRepository.delete(healthProfessional);
    }

    public HealthProfessional findById(UUID id) {
        return healthProfessionalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Health professional not found with id: " + id));
    }

    public HealthProfessional findByCpf(String cpf) {
        return healthProfessionalRepository.findByCpf(cpf)
                .orElseThrow(() -> new NotFoundException("Health professional not found with cpf: " + cpf));

    }

}
