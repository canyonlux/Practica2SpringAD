package org.example.practicaadapi_spring.service;

import org.example.practicaadapi_spring.model.Race;
import org.example.practicaadapi_spring.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RaceServiceImpl implements RaceService{
    private final RaceRepository repository;

    @Autowired
    public RaceServiceImpl(RaceRepository raceService){
        this.repository = raceService;
    }

    @Override
    public Optional<Race> findByRound(int round) {
        return repository.findByRound(round);
    }

    @Override
    public List<Race> getAllRaces() {
        return repository.findAll();
    }


    @Override
    public void saveRace(Race race) {
        repository.save(race);
    }

    @Override
    public void deleteRaceByRound(int round) {
        repository.deleteByRound(round);
    }

}