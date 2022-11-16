package com.example.eksamentestcykel.mapper;

import com.example.eksamentestcykel.bicycleRider.model.BicycleRider;
import com.example.eksamentestcykel.bicycleRider.repository.BicycleRiderRepository;
import com.example.eksamentestcykel.bicycleTeam.model.BicycleTeam;
import com.example.eksamentestcykel.bicycleTeam.repository.BicycleTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class dataMapper implements CommandLineRunner {

    @Autowired
    BicycleRiderRepository bicycleRiderRepo;

    @Autowired
    BicycleTeamRepository bicycleTeamRepo;

    @Override
    public void run(String... args) throws Exception {

        //testdata

        //BicycleTeam

        ArrayList<BicycleTeam> teamlist = new ArrayList<>();

        BicycleTeam teamOne = new BicycleTeam();
        teamOne.setBicycleTeamName("yellow");
        bicycleTeamRepo.save(teamOne);

        BicycleTeam teamTwo = new BicycleTeam();
        teamTwo.setBicycleTeamName("purple");
        bicycleTeamRepo.save(teamTwo);

        BicycleTeam teamThree = new BicycleTeam();
        teamThree.setBicycleTeamName("green");
        bicycleTeamRepo.save(teamThree);

        BicycleTeam teamFour = new BicycleTeam();
        teamFour.setBicycleTeamName("red");
        bicycleTeamRepo.save(teamFour);

        //BicycleRiders
        BicycleRider riderOne = new BicycleRider();
        riderOne.setName("carl");
        riderOne.setAge(20);
        riderOne.setMountainPoints(80);
        riderOne.setFastPoints(10);
        riderOne.setBicycleTeam(teamOne);
        bicycleRiderRepo.save(riderOne);

        BicycleRider riderTwo = new BicycleRider();
        riderOne.setName("Tom");
        riderOne.setAge(27);
        riderOne.setMountainPoints(120);
        riderOne.setFastPoints(22);
        riderOne.setBicycleTeam(teamTwo);
        bicycleRiderRepo.save(riderTwo);

        BicycleRider riderThree = new BicycleRider();
        riderOne.setName("Lars");
        riderOne.setAge(31);
        riderOne.setMountainPoints(130);
        riderOne.setFastPoints(20);
        riderOne.setBicycleTeam(teamThree);
        bicycleRiderRepo.save(riderThree);

        BicycleRider riderFour = new BicycleRider();
        riderOne.setName("Nissen");
        riderOne.setAge(35);
        riderOne.setMountainPoints(150);
        riderOne.setFastPoints(7);
        riderOne.setBicycleTeam(teamFour);
        bicycleRiderRepo.save(riderFour);


    }
}
