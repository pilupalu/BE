package com.group.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(Enrollment.EnrollmentId.class)
public class Enrollment {
    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_team")
    private Team teamId;

    @Id
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_activity")
    private Activity activityId;

    public static class EnrollmentId implements Serializable {
        private int teamId;

        private int activityId;

        // default constructor

        public EnrollmentId(int id_team, int id_activity) {
            this.teamId = id_team;
            this.activityId = id_activity;
        }

        // equals() and hashCode()
    }
}