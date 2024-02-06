package org.example.practicaadapi_spring.service;

import org.example.practicaadapi_spring.dto.ConstructorDTO;
import org.example.practicaadapi_spring.model.Constructor;

import java.util.List;
import java.util.Optional;

public interface ConstructorService {
    List<ConstructorDTO> getAllConstructors();
    Optional<Constructor> getConstructorByRef(String ref);
    Constructor saveConstructor(Constructor constructor);
    void deleteConstructorByRef(String ref);
}