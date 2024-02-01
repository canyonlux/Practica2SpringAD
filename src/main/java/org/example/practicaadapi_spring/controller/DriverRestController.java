package org.example.practicaadapi_spring.controller;

import org.example.practicaadapi_spring.model.Driver;
import org.example.practicaadapi_spring.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controlador REST para gestionar solicitudes relacionadas con entidades 'Driver'
@RestController
// Define la ruta base para todos los métodos de este controlador
@RequestMapping("/api")
public class DriverRestController {

    // Servicio que maneja la lógica de negocio y acceso a datos para 'Driver'
    private final DriverService driverService;

    // Constructor con inyección de dependencias para el servicio 'DriverService'
    @Autowired
    public DriverRestController(DriverService driverService) {
        this.driverService = driverService;
    }

    // Maneja solicitudes GET para obtener todos los conductores
    @GetMapping("/drivers")
    public ResponseEntity<List<Driver>> getAll(){
        // Devuelve la lista de conductores con un estado de respuesta HTTP 200 (OK)
        return ResponseEntity.ok(driverService.getAllDrivers());
    }

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
        // Verifica si el ID del conductor ya existe, si es así, devuelve un error de solicitud
        if (driver.getDriverId() != null)
            return ResponseEntity.badRequest().build();

        // Guarda el conductor y devuelve el objeto creado con un estado HTTP 200 (OK)
        this.driverService.saveDriver(driver);
        return ResponseEntity.ok(driver);
    }

    // Maneja solicitudes PUT para actualizar un conductor existente
    @PutMapping("/drivers")
    public ResponseEntity<Driver> update(@RequestBody Driver driver) {
        // Actualiza el conductor y devuelve el objeto actualizado con un estado HTTP 200 (OK)
        this.driverService.saveDriver(driver);
        return ResponseEntity.ok(driver);
    }

    // Maneja solicitudes DELETE para eliminar un conductor por su código
    @DeleteMapping("/drivers/{code}")
    public ResponseEntity<Driver> deleteByCode(@PathVariable String code) {
        // Elimina el conductor por código y devuelve un estado de respuesta HTTP 204 (No Content)
        this.driverService.deleteDriverByCode(code);
        return ResponseEntity.noContent().build();
    }

}
