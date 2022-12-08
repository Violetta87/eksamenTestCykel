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
    @Column(name = "id", nullable = false)
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

    //vi joiner bicycleriders med column team_id.
    //rider har en foreign key bicycle team - name skal referer til den column du gerne vil matche op med.
    @JoinColumn(name = "team_id", nullable = false)
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

    public BicycleRider(String name, int age, double totalTime, double mountainPoints, double fastPoints) {
        this.name = name;
        this.age = age;
        this.totalTime = totalTime;
        this.mountainPoints = mountainPoints;
        this.fastPoints = fastPoints;
    }

}
