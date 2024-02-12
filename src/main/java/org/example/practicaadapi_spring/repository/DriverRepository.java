package org.example.practicaadapi_spring.repository;

import jakarta.transaction.Transactional;
import org.example.practicaadapi_spring.dto.DriverPro;
import org.example.practicaadapi_spring.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

// Repositorio para la entidad 'Driver', extendiendo JpaRepository para funcionalidades CRUD básicas
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    Page<Driver> findAll(Pageable pageable); // Método para obtener una lista paginada de todos los conductores


    List<DriverPro> findAllProjectedBy(); // Método para obtener una lista de conductores con la proyección aplicada

    // Método para buscar un conductor por su código, ignorando mayúsculas/minúsculas
    Optional<Driver> findByCodeIgnoreCase(String code);


    @Transactional
    @Modifying
    @Query("DELETE FROM Driver d WHERE d.code = :code")
    void deleteByCode(String code);
}
