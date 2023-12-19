package org.example.practicaadapi_spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "drivers")
public class Driver {

    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driverid")
    private long driverId;

    @Column(unique = true)
    private String code;
    private String forename;
    private String surname;
    @JsonProperty("dateofbirth")
    private LocalDate dob;
    private String nationality;
    private String url;

}
