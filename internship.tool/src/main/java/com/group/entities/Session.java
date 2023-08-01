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
@IdClass(Session.SessionID.class)
public class Session {

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @JsonIgnoreProperties({"id_team","role","email","name"})
    private User user;

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_activity", referencedColumnName = "id")
    @JsonIgnoreProperties("name")
    private Activity activity;

    @Id
    @Column(name = "date")
    private String date;

    @Column(name = "attendance")
    private boolean attended;


    public static class SessionID implements Serializable {

        private int user;

        private int activity;

        private String date;

/*
        public SessionID(User user, Activity activity, String date) {
            this.user = user;
            this.activity = activity;
            this.date = date;
        }
*/

        public SessionID() {

        }

        public SessionID(int user, int activity, String date) {
            this.user = user;
            this.activity = activity;
            this.date = date;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SessionID sessionID = (SessionID) o;
            return user == sessionID.user && activity == sessionID.activity && Objects.equals(date, sessionID.date);
        }

        @Override
        public int hashCode() {
            return Objects.hash(user, activity, date);
        }
    }
}