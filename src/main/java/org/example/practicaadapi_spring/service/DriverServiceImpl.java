package org.example.practicaadapi_spring.service;

import jakarta.transaction.Transactional;
import org.example.practicaadapi_spring.dto.DriverPro;
import org.example.practicaadapi_spring.model.Driver;
import org.example.practicaadapi_spring.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
// Servicio marcado con @Service para la gestión de la entidad 'Driver'
@Service
public class DriverServiceImpl implements DriverService{

    // Repositorio para operaciones de base de datos con la entidad 'Driver'
    private final DriverRepository repository;

    // Inyección de dependencias para el repositorio 'DriverRepository'
    @Autowired
    private DriverRepository driverRepository;

    public List<DriverPro> findAllProjectedDrivers() {
        return repository.findAllProjectedBy();
    }

    public DriverServiceImpl(DriverRepository repository){
        this.repository = repository;
    }

    // Implementación del método para obtener todos los conductores
    @Override
    public List<Driver> getAllDrivers() {
        // Utiliza el método findAll del repositorio para obtener todos los conductores
        return repository.findAll();
    }

    // Implementación del método para buscar un conductor por su código
    @Override
    public Optional<Driver> getDriverByCode(String code) {
        // Utiliza el método findByCodeIgnoreCase del repositorio para buscar por código
        return repository.findByCodeIgnoreCase(code);
    }

    // Implementación del método para guardar (crear o actualizar) un conductor
    @Override
    public Driver saveDriver(Driver driver) {
        // Utiliza el método save del repositorio para guardar el conductor
        return repository.save(driver);
    }

    // Implementación del método para eliminar un conductor por su código
    @Override
    @Transactional // Asegura que la operación se ejecute dentro de una transacción
    public void deleteDriverByCode(String code) {
        // Utiliza el método deleteByCode del repositorio para eliminar el conductor
        repository.deleteByCode(code);
    }

}
