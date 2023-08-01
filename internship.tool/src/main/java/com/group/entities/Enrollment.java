package com.group.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties({"id_leader","team_name"})
    private Team id_team;

    @Id
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_activity", referencedColumnName = "id")
    @JsonIgnoreProperties({"name"})
    private Activity id_activity;

    public static class EnrollmentId implements Serializable {
        private int id_team;

        private int id_activity;

        public EnrollmentId() {
        }

        public EnrollmentId(int id_team, int id_activity) {
            this.id_team = id_team;
            this.id_activity = id_activity;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EnrollmentId that = (EnrollmentId) o;
            return id_team == that.id_team && id_activity == that.id_activity;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id_team, id_activity);
        }
    }
}