package com.group.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

class SessionID implements Serializable{
    private int activityId;

    private String date;

    private int userId;

    public SessionID(int activityId, int userId, String date){
        this.activityId = activityId;
        this.date = date;
        this.userId = userId;
    }
}
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(SessionID.class)
public class Session {

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_user")
    private User userId;

    @Id
    @Column(name = "session_activity_id")
    private int session_activity_id;

    @ManyToMany
    @JoinTable(
            name = "session_actity",
            joinColumns = @JoinColumn(name = "session_activity_id"),
            inverseJoinColumns = @JoinColumn(name = "id_activity")
    )
    List<Activity> activityList;

    @Id
    @Column(name = "date")
    private String date;

    @Column(name = "grade")
    private int session_grade;

    @Column(name = "comment")
    private String session_comments;



}