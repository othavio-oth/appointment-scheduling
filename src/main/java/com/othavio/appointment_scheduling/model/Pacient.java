package com.othavio.appointment_scheduling.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "pacients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pacient {

    public Pacient(UUID id) {
        this.id = id;
    }

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
