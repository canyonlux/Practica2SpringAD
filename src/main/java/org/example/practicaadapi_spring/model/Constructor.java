package org.example.practicaadapi_spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "constructors")
public class Constructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "constructorid")
    private Long id;
    @Column(name = "constructorref", unique = true, nullable = false)
    private String ref;
    @Column(unique = true, name = "name")

    private String name;
    private String nationality;
    private String url;

    @OneToMany(mappedBy = "constructor" , cascade = CascadeType.ALL)
    @JsonIgnoreProperties("constructor")
    private List<Driver> drivers;

}