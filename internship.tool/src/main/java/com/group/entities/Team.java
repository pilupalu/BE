package com.group.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_team")
    private int teamID;

    @Column(name = "team_name")
    private String teamName;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_leader")
    private User leader;
}
