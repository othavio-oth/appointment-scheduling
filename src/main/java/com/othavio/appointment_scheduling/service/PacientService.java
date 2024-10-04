package com.othavio.appointment_scheduling.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.othavio.appointment_scheduling.exceptions.NotFoundException;
import com.othavio.appointment_scheduling.model.Pacient;
import com.othavio.appointment_scheduling.repositories.PacientRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PacientService {

    @Autowired
    private final PacientRepository pacientRepository;

    public Pacient save(Pacient pacient) {
        return pacientRepository.save(pacient);
    }

    public List<Pacient> findAll() {
        return pacientRepository.findAll();
    }

    public Pacient findById(UUID id) {
        return pacientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pacient not found with id: " + id));
    }

    public void deleteById(UUID id) {
        Pacient pacient = findById(id);
        pacientRepository.delete(pacient);
    }

}
