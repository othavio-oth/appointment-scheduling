package com.othavio.appointment_scheduling.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.othavio.appointment_scheduling.model.Pacient;

@Repository
public interface PacientRepository extends JpaRepository<Pacient, UUID> {

    Pacient findByCpf(String cpf);

}
