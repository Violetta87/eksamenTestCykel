package com.example.eksamentestcykel.bicycleTeam.model;

import com.example.eksamentestcykel.bicycleRider.model.BicycleRider;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class BicycleTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id", nullable = false)
    private Long id;

    @Column(name = "team_name", nullable = false)
    private String bicycleTeamName;

    @Column(name = "manager", nullable = false)
    private String manager;

    //hvis data er relateret til hinanden - kan vi definere de forskellige
    @OneToMany(mappedBy = "bicycleTeam")
    //der er en tilbage reference til noget, og ved at sætte annotationen @JsonBackreference
    //fortæller spring frameworket at
    @JsonBackReference
    private List<BicycleRider> bicycleRiders;

    public BicycleTeam(String bicycleTeamName, String manager) {
        this.bicycleTeamName = bicycleTeamName;
        this.manager = manager;
    }
}