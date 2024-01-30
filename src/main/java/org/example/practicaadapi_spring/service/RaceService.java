package org.example.practicaadapi_spring.service;

import org.example.practicaadapi_spring.model.Race;

import java.util.List;
import java.util.Optional;

public interface RaceService {

    Optional<Race> findByRound(int round);
    List<Race> getAllRaces();
    void saveRace(Race race);

    void deleteRaceByRound(int round);

}