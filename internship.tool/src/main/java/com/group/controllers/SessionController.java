package com.group.controllers;

import com.group.entities.*;
import com.group.services.ActivityService;
import com.group.services.EnrollmentService;
import com.group.services.SessionService;
import com.group.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessions")
public class SessionController {
    @Autowired
    private SessionService sessionService;
    private EnrollmentService enrollmentService;
    private ActivityService activityService;
    private UserService userService;

    public SessionController(SessionService sessionService, EnrollmentService enrollmentService, ActivityService activityService, UserService userService) {
        this.sessionService = sessionService;
        this.enrollmentService = enrollmentService;
        this.activityService = activityService;
        this.userService = userService;
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Session> addSession(@RequestBody Session session){
        Session result = sessionService.addSession(session);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping
    public ResponseEntity<List<Session>> getSessionsForUserAndActivity(
            @RequestParam("userId") Integer userId,
            @RequestParam("activityId") Integer activityId
    ) {
        List<Session> sessions = sessionService.getSessionsByUserAndActivity(userId, activityId);
        if (sessions.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sessions);
    }

    @GetMapping(value = "/all")
    public List<Session> getAllSessions(){
        return sessionService.getAllSessions();
    }

    @PostMapping("/create-sessions")
    public ResponseEntity<String> createSessionsForActivityAndDate(@RequestParam("activityId") int activityId,
                                                                   @RequestParam("date") String date) {
        Activity activity = activityService.getActivityById(activityId);
        if (activity == null) {
            return new ResponseEntity<>("Activity not found", HttpStatus.NOT_FOUND);
        }

        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByActivity(activity);

        for (Enrollment enrollment : enrollments) {
            Team team = enrollment.getTeamId();
            List<User> students = userService.getUsersByFields(null, null, null, null, team.getId_team());

            for (User student : students) {
                Session session = new Session();
                session.setUser(student);
                session.setActivity(activity);
                session.setDate(date);
                session.setAttended(false); // Defaulting to false, as attendance is not specified at creation

                sessionService.addSession(session);
            }
        }

        return new ResponseEntity<>("Sessions created successfully", HttpStatus.OK);
    }
}
