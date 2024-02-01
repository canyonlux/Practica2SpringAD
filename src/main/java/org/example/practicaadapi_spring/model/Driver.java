package org.example.practicaadapi_spring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

// Define una entidad JPA para representar a un conductor en la base de datos
@Entity
// Lombok @Data genera automáticamente getters, setters, equals, hashCode y toString
@Data
// Define el nombre de la tabla en la base de datos para esta entidad
@Table(name = "drivers")
public class Driver {

    // Identifica este campo como la clave primaria de la entidad
    @Id
    // Configura la generación automática del ID (clave primaria) utilizando la estrategia de identidad
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driverid") // Especifica el nombre de la columna en la base de datos
    private Long driverId;

    // Define una columna única para el código del conductor
    @Column(unique = true)
    private String code;
    private String forename; // Nombre del conductor
    private String surname;  // Apellido del conductor

    // Anota el campo para mapear la fecha de nacimiento y permite su serialización/deserialización personalizada
    @JsonProperty("dateofbirth")
    private LocalDate dob;
    private String nationality; // Nacionalidad del conductor
    private String url;         // URL asociada al conductor

    // Define una relación muchos-a-uno con la entidad 'Constructor'
    @ManyToOne
    @JoinColumn(name = "constructorid") // Define la clave foránea para la relación
    @JsonIgnoreProperties("drivers")    // Evita la serialización de propiedades específicas en JSON
    private Constructor constructor;

    // Define una relación uno-a-muchos con la entidad 'Result'
    @OneToMany(mappedBy = "driver") // Mapea la relación basada en el campo 'driver' en 'Result'
    @JsonBackReference // Evita la recursión en la serialización JSON
    private Set<Result> results;
}
