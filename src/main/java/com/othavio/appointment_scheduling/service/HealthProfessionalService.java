package com.othavio.appointment_scheduling.service;

import java.util.List;
import java.util.UUID;
import com.othavio.appointment_scheduling.model.HealthProfessional;
import org.springframework.stereotype.Service;

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
        healthProfessionalRepository.deleteById(id);
    }

    public HealthProfessional findById(UUID id) {
        return healthProfessionalRepository.findById(id).orElse(null);
    }

}
