package com.example.eksamentestcykel.bicycleRider.controller;

import com.example.eksamentestcykel.bicycleRider.model.BicycleRider;
import com.example.eksamentestcykel.bicycleRider.service.BicycleRiderService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/BicycleRiders")
public class BicycleRiderController {

    private final BicycleRiderService service;

    public BicycleRiderController(BicycleRiderService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<BicycleRider>> findAll(){
        return ResponseEntity.ok().body(service.findALlBicycleriders());
    }

    @PostMapping
    public ResponseEntity<BicycleRider> create(@Valid @RequestBody BicycleRider bicycleRider){
        BicycleRider item = service.create(bicycleRider);
        return ResponseEntity.ok().body(item);
    }





}
