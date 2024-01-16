package org.example.practicaadapi_spring.repository;

import jakarta.transaction.Transactional;
import org.example.practicaadapi_spring.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    //metodo buscar pilotos por su codigo
    Optional<Driver> findByCodeIgnoreCase(String code);

    //metodo borrar driver por id
    @Transactional
    @Modifying
    @Query("DELETE FROM Driver d WHERE d.code = :code")
    void deleteByCode(String code);
}