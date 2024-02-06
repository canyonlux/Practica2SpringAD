package org.example.practicaadapi_spring.controller;

import org.example.practicaadapi_spring.model.Result;
import org.example.practicaadapi_spring.service.ResultServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ResultRestController {

    private final ResultServiceImpl resultService;

    @Autowired
    public ResultRestController(ResultServiceImpl resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/results")
    public ResponseEntity<List<Result>> getAllResults() {
        List<Result> results = resultService.findAll();
        return ResponseEntity.ok(results);
    }


}