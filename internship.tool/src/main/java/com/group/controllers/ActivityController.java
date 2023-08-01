package com.group.controllers;

import com.group.entities.Activity;
import com.group.entities.Team;
import com.group.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @PostMapping(value = "/new")
    public ResponseEntity<Activity> addActivity(@RequestBody Activity activity){
        Activity result = activityService.addActivity(activity);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping(value = "/all")
    public List<Activity> getAllActivity(){
        return activityService.getAllActivities();
    }
}
