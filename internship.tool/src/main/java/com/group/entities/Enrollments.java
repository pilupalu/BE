package com.group.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
class EnrollmentsId implements Serializable {
    private int teamId;

    private int activityId;

    // default constructor

    public EnrollmentsId(int id_team, int id_activity) {
        this.teamId = id_team;
        this.activityId = id_activity;
    }

    // equals() and hashCode()
}
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(EnrollmentsId.class)
public class Enrollments {
    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_activity")
    private Team teamId;

    @Id
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_activity")
    private Activity activityId;




}