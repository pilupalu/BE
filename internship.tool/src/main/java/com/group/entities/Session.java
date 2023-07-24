package com.group.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Embeddable
class SessionID implements Serializable{

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User user;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "activityId", referencedColumnName = "id_activity")
    private Activity activity;
    @Column(name = "date")
    private String date;

    public SessionID() {}
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

    @Column(name = "attendence")
    private boolean attended;
}