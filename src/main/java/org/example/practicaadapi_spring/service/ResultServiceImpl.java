package org.example.practicaadapi_spring.service;


import org.example.practicaadapi_spring.model.Result;
import org.example.practicaadapi_spring.repository.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {



    private final ResultsRepository resultRepository;

    @Autowired
    public ResultServiceImpl(ResultsRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public List<Result> findAll() {
        return resultRepository.findAll();
    }



}