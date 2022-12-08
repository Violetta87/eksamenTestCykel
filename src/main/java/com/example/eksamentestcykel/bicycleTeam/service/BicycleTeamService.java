package com.example.eksamentestcykel.bicycleTeam.service;

import com.example.eksamentestcykel.bicycleTeam.model.BicycleTeam;
import com.example.eksamentestcykel.bicycleTeam.repository.BicycleTeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BicycleTeamService {

    BicycleTeamRepository repo;

    public BicycleTeamService(BicycleTeamRepository repo) {
        this.repo = repo;
    }

    //create
    public BicycleTeam create(BicycleTeam team){
        return repo.save(team);
    }

    //read
    //vi finder et optional bicycleteam via et id.
    public Optional<BicycleTeam> get(long id){
        return repo.findById(id);
    }
    //vi finder alle teams
    public List<BicycleTeam> findAll(){
        return repo.findAll();
    }

    //update
    public BicycleTeam update(BicycleTeam bicycleTeam){
        //opretter et container objekt for derfor at kunne tilgå metoderne der kan checke om der eksisterer om en value eksisterer eller er null.
        Optional<BicycleTeam> optionalBicycleTeam = get(bicycleTeam.getId());
        if (optionalBicycleTeam.isEmpty()) {
            return null;
        }else{
            return repo.save(optionalBicycleTeam.get());
        }
    }

    //delete
    public Boolean delete(long id){
        Optional<BicycleTeam> optionalBicycleTeam = get(id);
        if (optionalBicycleTeam.isEmpty()) {
            return null;
        }else{
            repo.delete(optionalBicycleTeam.get());
            return true;
        }
    }

}






