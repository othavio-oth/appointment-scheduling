package com.othavio.appointment_scheduling.dtos.professional;

import com.othavio.appointment_scheduling.model.HealthProfessional;

public class HealthProfessionalMapper {

    public static HealthProfessionalDTO toDTO(HealthProfessional healthProfessional) {
        HealthProfessionalDTO dto = new HealthProfessionalDTO();
        dto.setId(healthProfessional.getId());
        dto.setName(healthProfessional.getName());
        dto.setEmail(healthProfessional.getEmail());
        dto.setCpf(healthProfessional.getCpf());
        return dto;
    }

    public static HealthProfessional toModel(HealthProfessionalDTO dto) {
        HealthProfessional healthProfessional = new HealthProfessional();
        healthProfessional.setId(dto.getId());
        healthProfessional.setName(dto.getName());
        healthProfessional.setEmail(dto.getEmail());
        healthProfessional.setCpf(dto.getCpf());
        return healthProfessional;
    }

}
