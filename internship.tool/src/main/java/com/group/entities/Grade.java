package com.group.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grade {

    @EmbeddedId
    private GradeID gradeID;

    @Column(name = "grade")
    private int grade;

    @Column(name = "comment")
    private String comment;

    @Embeddable
    public static class GradeID implements Serializable {
        private Session.SessionID sessionID;
        @Column(name = "id_mentor")
        private int mentorID;
    }
}
