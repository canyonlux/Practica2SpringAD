package org.example.practicaadapi_spring.repository;

import org.example.practicaadapi_spring.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {


}
