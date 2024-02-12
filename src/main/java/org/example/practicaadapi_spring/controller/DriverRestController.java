package org.example.practicaadapi_spring.controller;

import org.example.practicaadapi_spring.dto.DriverPro;
import org.example.practicaadapi_spring.model.Driver;
import org.example.practicaadapi_spring.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DriverRestController {

    // Servicio que maneja la lógica de negocio y acceso a datos para 'Driver'
    private final DriverService driverService;

    // Constructor con inyección de dependencias para el servicio 'DriverService'
    @Autowired
    public DriverRestController(DriverService driverService) {
        this.driverService = driverService;
    }



    // Maneja solicitudes GET para obtener todos los conductores con paginación
    @GetMapping("/drivers")
    public ResponseEntity<Page<Driver>> getAllDrivers(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "driverId") String sortBy,
            @RequestParam(defaultValue = "ASC") String sortDirection) {

        Page<Driver> drivers = driverService.getAllDrivers(page, size, sortBy, sortDirection);
        return ResponseEntity.ok(drivers);
    }


    // Utiliza el servicio para obtener la lista de conductores con la proyección aplicada
    @GetMapping("/drivers/projection")
    public ResponseEntity<List<DriverPro>> getAllDriversProjection() {
        List<DriverPro> drivers = driverService.findAllProjectedDrivers();
        return ResponseEntity.ok(drivers);
    }



//http://localhost:8080/api/drivers/alo
    // Maneja solicitudes GET para obtener un conductor por su código
    @GetMapping("/drivers/{code}")
    public ResponseEntity<Driver> getByCode(@PathVariable String code){
        // Busca el conductor por código y devuelve el resultado con el estado adecuado
        return this.driverService.getDriverByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    // Maneja solicitudes POST para crear un nuevo conductor
    @PostMapping("/drivers")
    public ResponseEntity<Driver> create(@RequestBody Driver driver) {
        if (driver.getDriverId() != null)
            return ResponseEntity.badRequest().build();
        this.driverService.saveDriver(driver);
        return ResponseEntity.ok(driver);
    }


    // Maneja solicitudes PUT para actualizar un conductor existente
    @PutMapping("/drivers")
    public ResponseEntity<Driver> update(@RequestBody Driver driver) {
        this.driverService.saveDriver(driver);
        return ResponseEntity.ok(driver);
    }


    // Maneja solicitudes DELETE para eliminar un conductor por su código
    @DeleteMapping("/drivers/{code}")
    public ResponseEntity<Driver> deleteByCode(@PathVariable String code) {
        this.driverService.deleteDriverByCode(code);
        return ResponseEntity.noContent().build();
    }

}
