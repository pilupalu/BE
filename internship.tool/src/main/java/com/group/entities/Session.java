package com.group.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

class SessionID implements Serializable{

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User user;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "activityId", referencedColumnName = "id_activity")
    private Activity activity;
    private String date;

    public SessionID(User user, Activity activity, String date) {
        this.user = user;
        this.activity = activity;
        this.date = date;
    }
}
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Session {

    @EmbeddedId
    private SessionID sessionID;

    @Column(name = "grade")
    private int grade;

    @Column(name = "comment")
    private String comments;

}