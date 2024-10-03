package com.othavio.appointment_scheduling.dtos.appointment;

import com.othavio.appointment_scheduling.dtos.pacient.PacientMapper;
import com.othavio.appointment_scheduling.dtos.professional.HealthProfessionalMapper;
import com.othavio.appointment_scheduling.model.AppointmentSlot;

public class AppointmentMapper {

    public static AppointmentDTO toDTO(AppointmentSlot appointment) {
        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(appointment.getId());
        dto.setStartTime(appointment.getStartTime());
        dto.setEndTime(appointment.getEndTime());
        dto.setCanceled(appointment.isCanceled());
        dto.setAvailable(appointment.isAvailable());
        dto.setPacient(PacientMapper.toDTO(appointment.getPacient()));
        dto.setHealthProfessional(HealthProfessionalMapper.toDTO(appointment.getHealthProfessional()));
        return dto;
    }

    public static AppointmentSlot toModel(AppointmentDTO dto) {
        AppointmentSlot appointment = new AppointmentSlot();
        appointment.setId(dto.getId());
        appointment.setStartTime(dto.getStartTime());
        appointment.setEndTime(dto.getEndTime());
        appointment.setCanceled(dto.isCanceled());
        appointment.setAvailable(dto.isAvailable());
        appointment.setPacient(PacientMapper.toModel(dto.getPacient()));
        appointment.setHealthProfessional(HealthProfessionalMapper.toModel(dto.getHealthProfessional()));
        return appointment;
    }

}
