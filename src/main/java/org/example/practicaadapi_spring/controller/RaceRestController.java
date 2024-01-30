package org.example.practicaadapi_spring.controller;
import org.example.practicaadapi_spring.model.Race;
import org.example.practicaadapi_spring.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RaceRestController {

    private final RaceService raceService;

    @Autowired
    public RaceRestController(RaceService raceService){
        this.raceService = raceService;
    }

    @GetMapping("/races")
    public ResponseEntity<List<Race>> getAll(){
        return ResponseEntity.ok(raceService.getAllRaces());
    }

    @GetMapping("/races/{round}")
    public ResponseEntity<Race> getByCode(@PathVariable int round){
        return this.raceService.findByRound(round)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/races")
    public ResponseEntity<Race> create(@RequestBody Race race){
        if(race.getRaceId() != null){
            return ResponseEntity.badRequest().build();
        }
        this.raceService.saveRace(race);
        return ResponseEntity.ok(race);
    }

    @PutMapping("/races")
    public ResponseEntity<Race> update(@RequestBody Race race){
        this.raceService.saveRace(race);
        return ResponseEntity.ok(race);
    }

    @Transactional
    @DeleteMapping("/races/{round}")
    public ResponseEntity<Race> deleteByCode(@PathVariable int round){
        this.raceService.deleteRaceByRound(round);
        return ResponseEntity.ok().build();
    }
}