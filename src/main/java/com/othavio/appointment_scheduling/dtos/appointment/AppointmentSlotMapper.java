package com.othavio.appointment_scheduling.dtos.appointment;

import com.othavio.appointment_scheduling.dtos.professional.HealthProfessionalMapper;
import com.othavio.appointment_scheduling.model.AppointmentSlot;
import com.othavio.appointment_scheduling.model.HealthProfessional;

public class AppointmentSlotMapper {

    public static AppointmentSlotDTO toDTO(AppointmentSlot appointment) {
        AppointmentSlotDTO dto = new AppointmentSlotDTO();
        dto.setId(appointment.getId());
        dto.setStartTime(appointment.getStartTime());
        dto.setEndTime(appointment.getEndTime());
        dto.setCanceled(appointment.isCanceled());
        dto.setAvailable(appointment.isAvailable());
        dto.setHealthProfessional(HealthProfessionalMapper.toDTO(appointment.getHealthProfessional()));
        return dto;
    }

    public static AppointmentSlot fromCreateDTOToModel(CreateAppointmentSlotDTO dto) {
        AppointmentSlot appointment = new AppointmentSlot();
        appointment.setId(dto.getId());
        appointment.setStartTime(dto.getStartTime());
        appointment.setEndTime(dto.getEndTime());
        appointment.setCanceled(dto.isCanceled());
        appointment.setAvailable(dto.isAvailable());
        appointment.setHealthProfessional(new HealthProfessional(dto.getHealthProfessionalId()));
        return appointment;
    }

}
