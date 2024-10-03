package com.othavio.appointment_scheduling.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity(name = "appointments")
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "pacient_id", nullable = false)
    private Pacient pacient;
    @OneToOne
    @JoinColumn(name = "appointment_slot_id", nullable = false)
    private AppointmentSlot appointmentSlot;
}
