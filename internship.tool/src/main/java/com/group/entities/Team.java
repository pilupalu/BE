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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int teamID;

    @Column(name = "name")
    private String teamName;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_leader", referencedColumnName = "id")
    @JsonIgnoreProperties("team")
    private User leader;
}
