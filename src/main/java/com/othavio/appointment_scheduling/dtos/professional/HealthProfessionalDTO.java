package com.othavio.appointment_scheduling.dtos.professional;

import java.util.UUID;

import lombok.Data;

@Data
public class HealthProfessionalDTO {

    private UUID id;
    private String name;
    private String email;
}
