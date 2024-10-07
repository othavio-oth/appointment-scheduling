package com.othavio.appointment_scheduling.dtos.pacient;

import com.othavio.appointment_scheduling.model.Pacient;

public class PacientMapper {

    public static PacientDTO toDTO(Pacient pacient) {
        PacientDTO dto = new PacientDTO();
        dto.setId(pacient.getId());
        dto.setName(pacient.getName());
        dto.setEmail(pacient.getEmail());
        dto.setCpf(pacient.getCpf());
        return dto;
    }

    public static Pacient toModel(PacientDTO dto) {
        System.out.println(dto.toString());
        Pacient pacient = new Pacient();
        pacient.setId(dto.getId());
        pacient.setName(dto.getName());
        pacient.setEmail(dto.getEmail());
        pacient.setCpf(dto.getCpf());
        return pacient;
    }

}
