package com.othavio.appointment_scheduling.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "pacients")
@Data
public class Pacient {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String email;
    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;
}
