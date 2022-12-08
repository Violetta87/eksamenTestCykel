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
        BicycleTeam teamOne = new BicycleTeam();
        teamOne.setBicycleTeamName("yellow");
        teamOne.setManager("Lars Hansen");
        bicycleTeamRepo.save(teamOne);

        BicycleTeam teamTwo = new BicycleTeam();
        teamTwo.setBicycleTeamName("purple");
        teamTwo.setManager("fia nini");
        bicycleTeamRepo.save(teamTwo);

        BicycleTeam teamThree = new BicycleTeam();
        teamThree.setBicycleTeamName("green");
        teamThree.setManager("theis Løvgreen");
        bicycleTeamRepo.save(teamThree);

        BicycleTeam teamFour = new BicycleTeam();
        teamFour.setBicycleTeamName("red");
        teamFour.setManager("tu tu ");
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
        riderTwo.setName("Tom");
        riderTwo.setAge(27);
        riderTwo.setMountainPoints(120);
        riderTwo.setFastPoints(22);
        riderTwo.setBicycleTeam(teamTwo);
        bicycleRiderRepo.save(riderTwo);

        BicycleRider riderThree = new BicycleRider();
        riderThree.setName("Lars");
        riderThree.setAge(31);
        riderThree.setMountainPoints(130);
        riderThree.setFastPoints(20);
        riderThree.setBicycleTeam(teamThree);
        bicycleRiderRepo.save(riderThree);

        BicycleRider riderFour = new BicycleRider();
        riderFour.setName("Nissen");
        riderFour.setAge(35);
        riderFour.setMountainPoints(150);
        riderFour.setFastPoints(7);
        riderFour.setBicycleTeam(teamFour);
        bicycleRiderRepo.save(riderFour);

    }
}
