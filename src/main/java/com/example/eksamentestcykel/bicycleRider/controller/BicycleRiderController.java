package com.example.eksamentestcykel.bicycleRider.controller;

import com.example.eksamentestcykel.bicycleRider.DTO.BicycleRiderDTO;
import com.example.eksamentestcykel.bicycleRider.model.BicycleRider;
import com.example.eksamentestcykel.bicycleRider.service.BicycleRiderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/bicycleRiders")
public class BicycleRiderController {
    //vi sætter den til en konstant, dvs. kan ikke ændres.
    private final BicycleRiderService service;
    private final BicycleRiderDTO dtoService;


    public BicycleRiderController(BicycleRiderService service, BicycleRiderDTO dtoService) {
        this.service = service;

        this.dtoService = dtoService;
    }

    @PostMapping
    public ResponseEntity<BicycleRider> create(@Valid @RequestBody BicycleRider bicycleRider){
        BicycleRider item = service.create(bicycleRider);
        return ResponseEntity.ok().body(item);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BicycleRider> find(@PathVariable("id") Long id) {
        Optional<BicycleRider> optionalBicycleRider = service.get(id);
        if (optionalBicycleRider.isPresent()) {
            return ResponseEntity.ok().body(optionalBicycleRider.get());
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<BicycleRiderDTO>> findAll(){
        return ResponseEntity.ok().body(service.of(service.findALl()));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BicycleRider> update(HttpSession session,
                                            @Valid @RequestBody BicycleRiderDTO bicycleRiderDTO,
                                            @PathVariable long id) {

        BicycleRider bicycleRider = BicycleRiderDTO.mapFromToDTO(bicycleRiderDTO);

        bicycleRider.setId(id);

        Optional<BicycleRider> result = service.update(bicycleRider);

        if (result.isPresent()) {
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable long id) {
        return ResponseEntity.ok().body(service.delete(id));
    }


}