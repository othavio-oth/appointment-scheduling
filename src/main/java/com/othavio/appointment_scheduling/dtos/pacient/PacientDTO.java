package com.othavio.appointment_scheduling.dtos.pacient;

import java.util.UUID;

import lombok.Data;

@Data
public class PacientDTO {

    private UUID id;
    private String name;
    private String email;

}
