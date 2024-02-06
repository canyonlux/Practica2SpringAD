package org.example.practicaadapi_spring.service;


import org.example.practicaadapi_spring.model.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResultService {


    List<Result> findAll();

}