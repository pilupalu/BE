package com.group.services;

import com.group.entities.Activity;
import com.group.entities.Enrollment;
import com.group.entities.Team;
import com.group.exceptions.TeamNotFoundInActivity;
import com.group.repositories.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityService {
    public final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> getAllActivities(){
        List<Activity> activityList;
        activityList = activityRepository.findAll();
        return activityList;
    }

    public Activity addActivity(Activity activity){
        Activity savedActivity = activityRepository.save(activity);
        return  savedActivity;
    }

    public Activity getActivityById(Integer activityId) {
        return activityRepository.findById(activityId).orElse(null);
    }

}
