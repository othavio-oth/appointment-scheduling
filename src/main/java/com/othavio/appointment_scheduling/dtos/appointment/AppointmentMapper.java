package com.othavio.appointment_scheduling.dtos.appointment;

import com.othavio.appointment_scheduling.dtos.pacient.PacientMapper;
import com.othavio.appointment_scheduling.model.Appointment;
import com.othavio.appointment_scheduling.model.AppointmentSlot;
import com.othavio.appointment_scheduling.model.Pacient;

public class AppointmentMapper {

    public static Appointment fromCreateDTOToModel(CreateAppointmentDTO dto) {
        Appointment appointment = new Appointment();
        appointment.setPacient(new Pacient(dto.getPacientId()));
        appointment.setAppointmentSlot(new AppointmentSlot(dto.getAppointmentSlotId()));
        return appointment;
    }

    public static AppointmentDTO toDTO(Appointment appointment) {
        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(appointment.getId());
        dto.setPacient(PacientMapper.toDTO(appointment.getPacient()));
        dto.setAppointmentSlot(AppointmentSlotMapper.toDTO(appointment.getAppointmentSlot()));
        return dto;
    }
}
