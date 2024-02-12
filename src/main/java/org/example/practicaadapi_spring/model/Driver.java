package org.example.practicaadapi_spring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driverid") // Especifica el nombre de la columna en la base de datos
    private Long driverId;
    @Column(unique = true)
    private String code;
    private String forename;
    private String surname;
    // Anota el campo para mapear la fecha de nacimiento y permite su serialización/deserialización personalizada
    @JsonProperty("dateofbirth")
    private LocalDate dob;
    private String nationality;
    private String url;

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
