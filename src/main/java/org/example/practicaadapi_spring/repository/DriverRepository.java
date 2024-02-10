package org.example.practicaadapi_spring.repository;

import jakarta.transaction.Transactional;
import org.example.practicaadapi_spring.dto.DriverPro;
import org.example.practicaadapi_spring.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Repositorio para la entidad 'Driver', extendiendo JpaRepository para funcionalidades CRUD básicas
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    List<DriverPro> findAllProjectedBy();

    // Método para buscar un conductor por su código, ignorando mayúsculas/minúsculas
    Optional<Driver> findByCodeIgnoreCase(String code);

    // Método para eliminar un conductor por su código
    // @Transactional asegura que la operación se ejecute dentro de una transacción de base de datos
    @Transactional
    // @Modifying indica que este método ejecuta una operación de modificación de base de datos
    @Modifying
    // @Query define una consulta JPQL personalizada para eliminar un conductor basándose en su código
    @Query("DELETE FROM Driver d WHERE d.code = :code")
    void deleteByCode(String code);
}
