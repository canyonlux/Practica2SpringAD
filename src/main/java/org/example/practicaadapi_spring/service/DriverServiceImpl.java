package org.example.practicaadapi_spring.service;

import org.example.practicaadapi_spring.model.Driver;
import org.example.practicaadapi_spring.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DriverServiceImpl implements DriverService{
    private final DriverRepository repository;

    @Autowired
    public DriverServiceImpl(DriverRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Driver> getAllDrivers() {
        return repository.findAll();
    }

    @Override
    public Optional<Driver> getDriverByCode(String code) {
        return repository.findDriverByCodeIgnoreCase(code);
    }
    public void deleteDriverByCode(String code) {
          repository.deleteDriverByCode(code);
    }
    public void saveDriver(Driver driver) {
        repository.save(driver);
    }
}
