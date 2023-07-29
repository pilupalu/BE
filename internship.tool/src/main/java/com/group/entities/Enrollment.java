package com.group.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(Enrollment.EnrollmentId.class)
public class Enrollment {
    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_team", referencedColumnName = "id")
    private Team teamId;

    @Id
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_activity", referencedColumnName = "id")
    private Activity activityId;

    public static class EnrollmentId implements Serializable {
        private int teamId;

        private int activityId;

        // default constructor

        public EnrollmentId() {
        }

        public EnrollmentId(int teamId, int activityId) {
            this.teamId = teamId;
            this.activityId = activityId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EnrollmentId that = (EnrollmentId) o;
            return teamId == that.teamId && activityId == that.activityId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(teamId, activityId);
        }

// equals() and hashCode()
    }
}