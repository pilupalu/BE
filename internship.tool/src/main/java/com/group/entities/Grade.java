package com.group.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
class GradeID implements Serializable{
    private SessionID sessionID;
    private int mentorID;
}

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
}
