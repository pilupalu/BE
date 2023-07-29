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
@IdClass(Grade.GradeID.class)
public class Grade {

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User userID;

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_activity", referencedColumnName = "id")
    private Activity activityID;

    @Id
    private String date;

    @Id
    @Column(name = "id_mentor")
    private int mentorID;

    @Column(name = "grade")
    private int grade;

    @Column(name = "comment")
    private String comment;

    public static class GradeID implements Serializable {
        private int userID;

        private int activityID;

        private String date;

        private int mentorID;

        public GradeID() {}

        public GradeID(int userID, int activityID, String date, int mentorID) {
            this.userID = userID;
            this.activityID = activityID;
            this.date = date;
            this.mentorID = mentorID;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GradeID gradeID = (GradeID) o;
            return userID == gradeID.userID && activityID == gradeID.activityID && mentorID == gradeID.mentorID && Objects.equals(date, gradeID.date);
        }

        @Override
        public int hashCode() {
            return Objects.hash(userID, activityID, date, mentorID);
        }
    }
}
