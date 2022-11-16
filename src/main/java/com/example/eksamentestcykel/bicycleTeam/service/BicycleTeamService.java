package com.example.eksamentestcykel.bicycleTeam.service;

import com.example.eksamentestcykel.bicycleTeam.model.BicycleTeam;
import com.example.eksamentestcykel.bicycleTeam.repository.BicycleTeamRepository;
import org.springframework.stereotype.Service;

@Service
public class BicycleTeamService {

    BicycleTeamRepository repo;

    //create
    public BicycleTeam create(BicycleTeam team){
        return repo.save(team);
    }

    //read


    //update

    //delete



}
