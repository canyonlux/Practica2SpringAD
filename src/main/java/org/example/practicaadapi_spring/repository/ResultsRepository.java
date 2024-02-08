package org.example.practicaadapi_spring.repository;


import org.example.practicaadapi_spring.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResultsRepository extends JpaRepository<Result, Long> {

}