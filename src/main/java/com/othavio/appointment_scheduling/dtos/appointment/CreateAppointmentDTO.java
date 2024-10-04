package com.othavio.appointment_scheduling.dtos.appointment;

import java.util.UUID;

import lombok.Data;

@Data
public class CreateAppointmentDTO {

    private UUID pacientId;
    private UUID appointmentSlotId;

}
