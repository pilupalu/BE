package com.group.services;

import com.group.entities.Session;
import com.group.repositories.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {
    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }
    public List<Session> getAllSessions() {
        List<Session> sessionList;
        sessionList = sessionRepository.findAll();
        return sessionList;
    }

    public Session addSession(Session session){
        Session savedSession = sessionRepository.save(session);
        return savedSession;
    }
}
