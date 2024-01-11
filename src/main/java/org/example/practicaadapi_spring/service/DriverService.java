package org.example.practicaadapi_spring.service;

import org.example.practicaadapi_spring.model.Driver;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface DriverService {

     List<Driver> getAllDrivers();

     Optional<Driver> getDriverByCode(String code);

     void saveDriver(Driver driver);

     void deleteDriverByCode(String code);
}