package com.group.services;

import com.group.entities.Activity;
import com.group.entities.Enrollment;
import com.group.entities.Team;
import com.group.repositories.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
