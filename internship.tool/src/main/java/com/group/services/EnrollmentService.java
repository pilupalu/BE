package com.group.services;

import com.group.entities.Enrollment;
import com.group.repositories.EnrollmentRepository;
import org.springframework.stereotype.Service;

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

    public Enrollment addEnrollment(Enrollment enrollment) {
        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);
        return  enrollment;
    }
}
