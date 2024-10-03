package com.othavio.appointment_scheduling.dtos.appointment;

import java.time.LocalDateTime;
import java.util.UUID;

import com.othavio.appointment_scheduling.dtos.pacient.PacientDTO;
import com.othavio.appointment_scheduling.dtos.professional.HealthProfessionalDTO;

import lombok.Data;

@Data
public class AppointmentDTO {

    private UUID id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean canceled;
    private boolean available;
    private PacientDTO pacient;
    private HealthProfessionalDTO healthProfessional;

}
