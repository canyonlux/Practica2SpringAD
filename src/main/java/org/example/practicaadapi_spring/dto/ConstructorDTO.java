package org.example.practicaadapi_spring.dto;
import lombok.Getter;
import lombok.Setter;
import org.example.practicaadapi_spring.model.Constructor;

@Getter
@Setter
    public class ConstructorDTO {
        private String name;
        private String nationality;

        public ConstructorDTO(Constructor constructor) {
            this.name = constructor.getName();
            this.nationality = constructor.getNationality();
        }
    }



