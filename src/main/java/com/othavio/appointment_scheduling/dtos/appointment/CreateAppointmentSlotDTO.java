package com.othavio.appointment_scheduling.dtos.appointment;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class CreateAppointmentSlotDTO {
    private UUID id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean canceled;
    private boolean available;
    private UUID healthProfessionalId;
}
