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
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "team_name", nullable=true)
    private String bicycleTeamName;

    //hvis data er relateret til hinanden - kan vi definere de forskellige
    @OneToMany(mappedBy = "bicycleTeam")
    //@JsonManagedReference //tager listen med.
    private List<BicycleRider> bicycleRiders;

    public BicycleTeam(String bicycleTeamName) {
        this.bicycleTeamName = bicycleTeamName;
    }
}
