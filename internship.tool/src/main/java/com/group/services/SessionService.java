package com.group.services;

import com.group.entities.Activity;
import com.group.entities.Session;
import com.group.entities.User;
import com.group.repositories.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SessionService {
    private final SessionRepository sessionRepository;
    private UserService userService;

    private ActivityService activityService;

    public SessionService(SessionRepository sessionRepository, UserService userService, ActivityService activityService) {
        this.sessionRepository = sessionRepository;
        this.userService = userService;
        this.activityService = activityService;
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

    public List<Session> getSessionsByUserAndActivity(Integer userId, Integer activityId) {
        // Assuming you have methods to fetch the user and activity by their IDs
        User user = userService.getUserById(userId);
        Activity activity = activityService.getActivityById(activityId);

        if (user == null || activity == null) {
            return Collections.emptyList();
        }

        return sessionRepository.findByUserAndActivity(user, activity);
    }
}
