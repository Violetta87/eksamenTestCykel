package com.example.eksamentestcykel.bicycleRider.service;

import com.example.eksamentestcykel.bicycleRider.model.BicycleRider;
import com.example.eksamentestcykel.bicycleRider.repository.BicycleRiderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BicycleRiderService {

    BicycleRiderRepository repository;

    public BicycleRiderService(BicycleRiderRepository repository) {
        this.repository = repository;
    }

    //create metode, vi kalder metoden fra JPArepository
    public BicycleRider create(BicycleRider bicycleRider) {
        return repository.save(bicycleRider);
    }

    //metode returnere en optional bicyclerider som vi finder via id.
    public Optional<BicycleRider> get(long id) {
        return repository.findById(id);
    }

    //update
    //vi vil gerne returner en bicyclerider
    public BicycleRider update(BicycleRider bicycleRider) {
        return repository.save(bicycleRider);
    }

    //slette
    public boolean delete(long id){
        //vi returnerer en boolean
        // Først skal vi have fat i en bicycle rider
        //bruger en optional til at håndtere om der findes noget.

        Optional<BicycleRider> optionalBicycleRider = get(id);

        //if statement der checker om der eksisterer noget,hvis ja skal der kaldes delete funtionen.
        //ellers returneres false.

        if(optionalBicycleRider.isPresent()){
            repository.delete(optionalBicycleRider.get());
            return true;
        }else{
            return false;
        }

    }

    //returnere en liste med alle bicycleriders.
    public List<BicycleRider> findALlBicycleriders(){
        return repository.findAll();
    }


}