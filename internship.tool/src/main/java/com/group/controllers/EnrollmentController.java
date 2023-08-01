package com.group.controllers;

import com.group.entities.Activity;
import com.group.entities.Enrollment;
import com.group.entities.Team;
import com.group.exceptions.ActivityNotFoundException;
import com.group.exceptions.TeamNotFoundInActivity;
import com.group.repositories.ActivityRepository;
import com.group.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;
    private final ActivityRepository activityRepository;

    public EnrollmentController(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }


    @PostMapping(value = "/newEnrollment")
    public ResponseEntity<Enrollment> addEnrollment(@RequestBody Enrollment enrollment) {
        Enrollment result = enrollmentService.addEnrollment(enrollment);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping(value = "/allEnrollment")
    public List<Enrollment> getAllEnrollments(){
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping
    public ResponseEntity<List<Team>> getTeamsEnrolledInActivity(@RequestParam Integer activityId) {
        // Fetch the Activity object based on the activityId.
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ActivityNotFoundException(HttpStatus.NOT_FOUND));

        try {
            List<Team> teams = enrollmentService.getTeamsEnrolledInActivity(activity);
            return ResponseEntity.ok(teams);
        } catch (TeamNotFoundInActivity ex) {
            return ResponseEntity.notFound().build();
        }
    }

}
