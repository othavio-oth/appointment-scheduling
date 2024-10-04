package com.othavio.appointment_scheduling.dtos.appointment;

import com.othavio.appointment_scheduling.dtos.pacient.PacientDTO;
import java.util.UUID;
import lombok.Data;

@Data

public class AppointmentDTO {

    private UUID id;
    private PacientDTO pacient;
    private AppointmentSlotDTO appointmentSlot;

}
