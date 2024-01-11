package org.example.practicaadapi_spring.service;

import org.example.practicaadapi_spring.repository.DriverRepository;

public class DriverServiceImplBuilder {
    private DriverRepository repository;

    public DriverServiceImplBuilder setRepository(DriverRepository repository) {
        this.repository = repository;
        return this;
    }

    public DriverServiceImpl createDriverServiceImpl() {
        return new DriverServiceImpl(repository);
    }
}