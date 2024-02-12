package org.example.practicaadapi_spring.service;

import org.example.practicaadapi_spring.dto.DriverPro;
import org.example.practicaadapi_spring.model.Driver;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Interfaz que define los servicios para la entidad 'Driver'
public interface DriverService {

    List<DriverPro> findAllProjectedDrivers(); // Método para obtener una lista de conductores con la proyección aplicada

    // Método actualizado para obtener una lista paginada de todos los conductores
    Page<Driver> getAllDrivers(int page, int size, String sortBy, String sortDirection);

    // Método para obtener un conductor por su código. Retorna un Optional de Driver.
    Optional<Driver> getDriverByCode(String code);




    Driver saveDriver(Driver driver);

    void deleteDriverByCode(String code);
}
