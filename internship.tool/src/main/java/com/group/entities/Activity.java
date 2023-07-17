package com.group.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    @Id
    @Column(name = "id_activity")
    private int id;

    @ManyToMany
    @JoinTable(
            name = "activity_team",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "id_activity")
    )
    List<Team> teams;

    @Column(name = "activity_name")
    private String activityName;
}