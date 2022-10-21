package com.example.eksamentestcykel.bicycleRider.model;

import com.example.eksamentestcykel.bicycleTeam.model.BicycleTeam;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@Table(name = "bicycle_rider")
public class BicycleRider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "bicycle_rider_name")
    private String name;
    @Column(name = "bicycle_rider_age")
    private int age;
    @Column(name = "total_time")
    private double totalTime;
    @Column(name = "mountain_points")
    private double mountainPoints;
    @Column(name = "fast_points")
    private double fastPoints;



    @JsonManagedReference
    @ManyToOne()
    @JoinColumn(name = "team_id", nullable = false)
    private BicycleTeam bicycleTeam;





}
