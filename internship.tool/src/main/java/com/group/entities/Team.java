package com.group.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Team", schema = "practice")
public class Team {

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_leader", referencedColumnName = "id")
    @JsonIgnoreProperties({"id_team","role","email","name"})
    private User id_leader;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id_team;

    @Column(name = "name")
    private String team_name;
}
