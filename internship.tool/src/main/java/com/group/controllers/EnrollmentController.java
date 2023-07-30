package com.group.controllers;

import com.group.entities.Activity;
import com.group.entities.Enrollment;
import com.group.entities.Team;
import com.group.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping(value = "/newEnrollment")
    public ResponseEntity<Enrollment> addEnrollment(@RequestBody Enrollment enrollment) {
        Enrollment result = enrollmentService.addEnrollment(enrollment);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping(value = "/allEnrollment")
    public List<Enrollment> getAllEnrollments(){
        return enrollmentService.getAllEnrollments();
    }
}
