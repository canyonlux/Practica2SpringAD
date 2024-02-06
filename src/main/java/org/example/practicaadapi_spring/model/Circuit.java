package org.example.practicaadapi_spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "circuits")
public class Circuit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "circuitid")
    private Long circuitId;

    @Column(unique = true, name = "circuitref", nullable = false)
    private String circuitRef;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "country")
    private String country;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lng")
    private Double lng;

    @Column(name = "alt")
    private Integer alt;

    @Column(name = "url")
    private String url;


    @OneToOne(mappedBy = "circuit")
    @JsonIgnoreProperties("circuit")
    private Race race;
}