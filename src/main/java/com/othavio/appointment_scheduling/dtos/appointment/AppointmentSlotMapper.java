package com.othavio.appointment_scheduling.dtos.appointment;

import com.othavio.appointment_scheduling.dtos.professional.HealthProfessionalMapper;
import com.othavio.appointment_scheduling.model.AppointmentSlot;
import com.othavio.appointment_scheduling.model.HealthProfessional;

public class AppointmentSlotMapper {

    public static AppointmentDTO toDTO(AppointmentSlot appointment) {
        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(appointment.getId());
        dto.setStartTime(appointment.getStartTime());
        dto.setEndTime(appointment.getEndTime());
        dto.setCanceled(appointment.isCanceled());
        dto.setAvailable(appointment.isAvailable());
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
        appointment.setHealthProfessional(new HealthProfessional(dto.getHealthProfessional().getId()));
        return appointment;
    }

}
