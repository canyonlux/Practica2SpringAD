package org.example.practicaadapi_spring.repository;

import org.example.practicaadapi_spring.model.Circuit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CircuitRepository extends JpaRepository<Circuit, Long> {

    Optional<Circuit> findByCircuitRefIgnoreCase(String circuitRef);
    void deleteByCircuitRef(String circuitRef);
}