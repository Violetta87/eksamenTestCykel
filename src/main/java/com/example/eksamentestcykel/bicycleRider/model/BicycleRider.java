package com.example.eksamentestcykel.bicycleRider.model;

import com.example.eksamentestcykel.bicycleTeam.model.BicycleTeam;
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

    @Column(name = "bicycle_rider_name", nullable = true)
    private String name;
    @Column(name = "bicycle_rider_age",nullable = true)
    private int age;
    @Column(name = "total_time", nullable = true)
    private double totalTime;
    @Column(name = "mountain_points",nullable = true)
    private double mountainPoints;
    @Column(name = "fast_points", nullable = true)
    private double fastPoints;


    @JoinColumn(name = "team_name", nullable = false)
    @ManyToOne
    private BicycleTeam bicycleTeam;

    public BicycleRider(String name, int age, double totalTime, double mountainPoints, double fastPoints, BicycleTeam bicycleTeam) {
        this.name = name;
        this.age = age;
        this.totalTime = totalTime;
        this.mountainPoints = mountainPoints;
        this.fastPoints = fastPoints;
        this.bicycleTeam = bicycleTeam;
    }
}
