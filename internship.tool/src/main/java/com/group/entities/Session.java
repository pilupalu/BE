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
public class Session {

    @EmbeddedId
    private SessionID sessionID;

    @Column(name = "attendence")
    private boolean attended;

    @Embeddable
    public static class SessionID implements Serializable {

        @ManyToOne(cascade = CascadeType.PERSIST)
        @JoinColumn(name = "id_user", referencedColumnName = "id")
        private User user;
        @ManyToOne(cascade = CascadeType.PERSIST)
        @JoinColumn(name = "activityId", referencedColumnName = "id")
        private Activity activity;
        @Column(name = "date")
        private String date;

        public SessionID(User user, Activity activity, String date) {
            this.user = user;
            this.activity = activity;
            this.date = date;
        }

        public SessionID() {

        }
    }
}