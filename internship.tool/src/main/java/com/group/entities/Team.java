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
    @Column(name = "id")
    private int teamID;

    @Column(name = "name")
    private String teamName;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_leader", referencedColumnName = "id")
    private User leader;
}
