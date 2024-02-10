package org.example.practicaadapi_spring.service;

import org.example.practicaadapi_spring.dto.DriverPro;
import org.example.practicaadapi_spring.model.Driver;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Interfaz que define los servicios para la entidad 'Driver'
public interface DriverService {

    List<DriverPro> findAllProjectedDrivers();

    // Método para obtener una lista de todos los conductores
    List<Driver> getAllDrivers();

    // Método para obtener un conductor por su código. Retorna un Optional de Driver.
    Optional<Driver> getDriverByCode(String code);

    // Método para guardar un conductor en la base de datos. Puede ser usado para crear o actualizar un conductor.
    Driver saveDriver(Driver driver);

    // Método para eliminar un conductor por su código
    void deleteDriverByCode(String code);

}
