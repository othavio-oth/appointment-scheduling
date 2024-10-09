package com.othavio.appointment_scheduling.dtos.professional;

import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HealthProfessionalDTO {

    private UUID id;
    private String name;

    @NotBlank(message = "Please provide a CPF")
    @CPF(message = "Invalid CPF")
    private String cpf;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    private String email;
}
