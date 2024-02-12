package org.example.practicaadapi_spring.service;

import jakarta.transaction.Transactional;
import org.example.practicaadapi_spring.dto.DriverPro;
import org.example.practicaadapi_spring.model.Driver;
import org.example.practicaadapi_spring.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {
    private final DriverRepository repository;

    @Autowired
    public DriverServiceImpl(DriverRepository repository) {
        this.repository = repository;
    }
@Override
    public List<DriverPro> findAllProjectedDrivers() {
        return repository.findAllProjectedBy();
    }

    // Implementación del método para obtener todos los conductores con paginación
    @Override
    public Page<Driver> getAllDrivers(int page, int size, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        PageRequest pageable = PageRequest.of(page, size, sort);
        return repository.findAll(pageable);
    }

    // Implementación del método para buscar un conductor por su código
    @Override
    public Optional<Driver> getDriverByCode(String code) {
        return repository.findByCodeIgnoreCase(code);
    }

    // Implementación del método para guardar (crear o actualizar) un conductor
    @Override
    public Driver saveDriver(Driver driver) {
        return repository.save(driver);
    }

    @Override
    @Transactional
    public void deleteDriverByCode(String code) {
        repository.deleteByCode(code);
    }
}
