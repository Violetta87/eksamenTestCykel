package com.example.eksamentestcykel.bicycleTeam.controller;

import com.example.eksamentestcykel.bicycleTeam.model.BicycleTeam;
import com.example.eksamentestcykel.bicycleTeam.service.BicycleTeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/BicycleTeam")
public class BicycleTeamController {
    private final BicycleTeamService service;

    public BicycleTeamController(BicycleTeamService service) {
        this.service = service;
    }

    //CREATE - vi opretter
    @PostMapping
    public ResponseEntity<BicycleTeam> create(@Valid @RequestBody BicycleTeam bicycleTeam){
        return ResponseEntity.ok().body(service.create(bicycleTeam));
    }

    //find via id
    @GetMapping("/{id}/find")
    public ResponseEntity<BicycleTeam> find(@PathVariable("id") Long id){
        Optional<BicycleTeam> optionalBicycleTeam = service.get(id);
        if(optionalBicycleTeam.isEmpty()){
            return ResponseEntity.ok().body(optionalBicycleTeam.get());
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    //findall.
    @GetMapping
    public ResponseEntity<List<BicycleTeam>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    //update
    @PatchMapping("/{id}")
    public ResponseEntity<BicycleTeam> update(@PathVariable("id") Long id, @Valid @RequestBody BicycleTeam bicycleTeam){
        bicycleTeam.setId(id);
        return ResponseEntity.ok().body(service.update(bicycleTeam));
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable long id) {
        return ResponseEntity.ok().body(service.delete(id));
    }



}
