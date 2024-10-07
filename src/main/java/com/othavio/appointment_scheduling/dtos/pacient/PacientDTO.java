package com.othavio.appointment_scheduling.dtos.pacient;

import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PacientDTO {

    private UUID id;

    @NotBlank(message = "Please provide a name")
    private String name;

    @CPF(message = "Invalid CPF")
    @NotBlank(message = "CPF is required")
    private String cpf;

    @Column(unique = true)
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    private String email;

}
