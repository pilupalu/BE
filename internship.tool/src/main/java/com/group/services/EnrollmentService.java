package com.group.services;

import com.group.entities.Activity;
import com.group.entities.Enrollment;
import com.group.entities.Team;
import com.group.exceptions.TeamNotFoundInActivity;
import com.group.repositories.EnrollmentRepository;
import com.group.repositories.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final TeamRepository teamRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository, TeamRepository teamRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.teamRepository = teamRepository;
    }

    public List<Enrollment> getAllEnrollments(){
        List<Enrollment> enrollmentList;
        enrollmentList = enrollmentRepository.findAll();
        return enrollmentList;
    }

    public List<Activity> getActivityByTeam(Team team){
        List<Enrollment> enrollments = enrollmentRepository.findByTeamId(team);
        List<Activity> activities = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            activities.add(enrollment.getId_activity());
        }
        return activities;
    }

    public Enrollment addEnrollment(Enrollment enrollment) {
        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);
        return  enrollment;
    }

    public List<Team> getTeamsEnrolledInActivity(Activity activity) {
        List<Enrollment> enrollments = enrollmentRepository.findByActivityId(activity);
        if (enrollments.isEmpty()) {
            throw new TeamNotFoundInActivity(HttpStatus.NOT_FOUND);
        }

        List<Team> teams = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            teams.add(enrollment.getId_team());
        }
        return teams;
    }

    public List<Enrollment> getEnrollmentsByActivity(Activity activity) {
        return enrollmentRepository.findByActivityId(activity);
    }

    public List<Activity> getEnrolledActivitiesByTeamId(int teamId) {
        // Fetch the team by team ID
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new TeamNotFoundInActivity(HttpStatus.NOT_FOUND));

        // Fetch the enrollments for the given team
        List<Enrollment> enrollments = enrollmentRepository.findByTeamId(team);

        // Extract the activities from enrollments
        List<Activity> activities = enrollments.stream()
                .map(Enrollment::getId_activity)
                .collect(Collectors.toList());

        return activities;
    }
}
