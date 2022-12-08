package com.example.eksamentestcykel.bicycleRider.repository;

import com.example.eksamentestcykel.bicycleRider.DTO.BicycleRiderDTO;
import com.example.eksamentestcykel.bicycleRider.model.BicycleRider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BicycleRiderRepository extends JpaRepository<BicycleRider, Long> {
}
