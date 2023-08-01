package com.group.services;

import com.group.entities.Activity;
import com.group.entities.Enrollment;
import com.group.entities.Team;
import com.group.exceptions.TeamNotFoundInActivity;
import com.group.repositories.EnrollmentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
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
            activities.add(enrollment.getActivityId());
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
            teams.add(enrollment.getTeamId());
        }
        return teams;
    }
}
