package org.example.practicaadapi_spring.service;

import org.example.practicaadapi_spring.model.Driver;
import org.example.practicaadapi_spring.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
}
