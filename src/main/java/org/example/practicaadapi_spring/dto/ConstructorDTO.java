package org.example.practicaadapi_spring.dto;
import lombok.Getter;
import lombok.Setter;
import org.example.practicaadapi_spring.model.Constructor;
import org.example.practicaadapi_spring.model.Constructor;

public record ConstructorDTO(String name, String nationality) {
    public ConstructorDTO(Constructor constructor) { //
        this(constructor.getName(), constructor.getNationality());
    }
}




