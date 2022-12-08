package com.example.eksamentestcykel.bicycleRider.service;

import com.example.eksamentestcykel.bicycleRider.DTO.BicycleRiderDTO;
import com.example.eksamentestcykel.bicycleRider.model.BicycleRider;
import com.example.eksamentestcykel.bicycleRider.repository.BicycleRiderRepository;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BicycleRiderService {

    private BicycleRiderRepository repository;

    public BicycleRiderService(BicycleRiderRepository repository) {
        this.repository = repository;
    }

    /
    public BicycleRider create(BicycleRider bicycleRider) {
        return repository.save(bicycleRider);
    }

    public Optional<BicycleRider> get(long id) {
        return repository.findById(id);
    }


    public List<BicycleRider> findALl(){
        return repository.findAll();
    }

    public BicycleRider update(BicycleRider bicycleRider) {
        Optional<BicycleRider> optionalBicycleRider = get(bicycleRider.getId());
        if(optionalBicycleRider.isEmpty()){
            return null;
        }else{
            return repository.save(optionalBicycleRider.get());
        }

    }

    public boolean delete(long id){
        //vi returnerer en boolean
        // Først skal vi have fat i en bicycle rider
        //bruger en optional til at håndtere om der findes noget.
        Optional<BicycleRider> optionalBicycleRider = get(id);

        //Hvis der eksisterer en bicyclerider slettes den, og returneres true.

        if(optionalBicycleRider.isPresent()){
            repository.delete(optionalBicycleRider.get());
            return true;
        }else{
            return false;
        }

    }
    public static List<BicycleRiderDTO> of(List<BicycleRider> entities) {
        return entities.stream()
                .sorted(Comparator.comparing(BicycleRider::getTotalTime))
                .map(BicycleRiderDTO::of).collect(Collectors.toList());

    }





}