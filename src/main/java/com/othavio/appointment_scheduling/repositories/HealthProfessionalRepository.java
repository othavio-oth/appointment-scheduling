package com.othavio.appointment_scheduling.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.othavio.appointment_scheduling.model.HealthProfessional;

@Repository
public interface HealthProfessionalRepository extends JpaRepository<HealthProfessional, UUID> {

    Optional<HealthProfessional> findByCpf(String cpf);
}