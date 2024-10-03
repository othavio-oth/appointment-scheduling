package com.othavio.appointment_scheduling.dtos.pacient;

import com.othavio.appointment_scheduling.model.Pacient;

public class PacientMapper {

    public static PacientDTO toDTO(Pacient pacient) {
        PacientDTO dto = new PacientDTO();
        dto.setId(pacient.getId());
        dto.setName(pacient.getName());
        dto.setEmail(pacient.getEmail());
        return dto;
    }

    public static Pacient toModel(PacientDTO dto) {
        Pacient pacient = new Pacient();
        pacient.setId(dto.getId());
        pacient.setName(dto.getName());
        pacient.setEmail(dto.getEmail());
        return pacient;
    }

}
