package org.example.practicaadapi_spring.controller;

import org.example.practicaadapi_spring.model.Driver;
import org.example.practicaadapi_spring.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")

public class DriverRestController {
    private final DriverService driverService;

    @Autowired
    public DriverRestController(DriverService service) {
        this.driverService = service;
    }

    @GetMapping("/drivers/{code}")
    public ResponseEntity<Driver> getByCode(@PathVariable String code) {
        return this.driverService.getDriverByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    public ResponseEntity<Driver> create(@RequestBody Driver driver) {
        if (driver.getDriverId() != null)
            return ResponseEntity.badRequest().build();

        this.driverService.saveDriver(driver);
        return ResponseEntity.ok(driver);
    }
    @PostMapping("/drivers")


    @PutMapping("/drivers")
    public ResponseEntity<Driver> update(@RequestBody Driver driver) {
        this.driverService.saveDriver(driver);
        return ResponseEntity.ok(driver);

    }

    @DeleteMapping("/drivers/{code}")
    public ResponseEntity<Driver> deleteByCode(@PathVariable String code) {
                    this.driverService.deleteDriverByCode(code);
                    return ResponseEntity.noContent().build();
                }

    }

