package com.example.eksamentestcykel.bicycleRider.service;

import com.example.eksamentestcykel.bicycleRider.model.BicycleRider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BicycleRiderServiceTest {

    @Autowired
    private BicycleRiderService service;

    @Test
    void create(){

        //vi laver unit test ved hjælp af junit test, som er et bibliotek vi importerer.

        //arrange
        //expected bicyclerider
        //skal oprette team, for at kunne checke, da team kan ikke være tom.


        String name ="CAm";
        int age = 34;
        double totalTime =200.3;
        double mountainPoints=100.1;
        double fast_points = 30;

        //

        //act
        BicycleRider expectedBicyclerider = new BicycleRider(name,age,totalTime,mountainPoints,fast_points);
        BicycleRider result = service.create(expectedBicyclerider);

        //assert

        assertEquals(expectedBicyclerider, result);

    }



}