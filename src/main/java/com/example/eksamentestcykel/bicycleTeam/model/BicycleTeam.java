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
    private Long id;

    @Column(name = "team_name")
    private String bicycleTeamName;


    @OneToMany(mappedBy = "bicycleTeam", cascade = {CascadeType.ALL})
    @JsonManagedReference //tager listen med.
    private List<BicycleRider> bicycleRiders;

}
