package org.example.practicaadapi_spring.mapper;
import org.example.practicaadapi_spring.dto.ConstructorDTO;
import org.example.practicaadapi_spring.model.Constructor;
import org.springframework.stereotype.Service;
import java.util.function.Function;


@Service
public class ConstructorDtoMapper implements Function<Constructor, ConstructorDTO> {
    // Clase que mapea un objeto de tipo 'Constructor' a un objeto de tipo 'ConstructorDTO'

    @Override
    public ConstructorDTO apply(Constructor constructor) {
        if (constructor == null) {
            return null;
        }

        return new ConstructorDTO(constructor);
    }
}