package com.othavio.appointment_scheduling.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity(name = "appointment_slots")
@Data
public class AppointmentSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "health_professional_id", nullable = false)
    private HealthProfessional healthProfessional;

}
