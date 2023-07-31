package com.group.services;

import com.group.entities.Activity;
import com.group.entities.Grade;
import com.group.entities.User;
import com.group.repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ActivityService activityService;

    public GradeService() {}

    public GradeService(GradeRepository gradeRepository, UserService userService, ActivityService activityService) {
        this.gradeRepository = gradeRepository;
        this.userService = userService;
        this.activityService = activityService;
    }

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }
    public List<Grade> getAllGrades() {
        List<Grade> gradeList;
        gradeList = gradeRepository.findAll();
        return gradeList;
    }

    public List<Grade> getGradesByUserActivityAndDate(int userId, int activityId, String date) {
        // Assuming you have methods to fetch the user and activity by their IDs
        User user = userService.getUserById(userId);
        Activity activity = activityService.getActivityById(activityId);

        if (user == null || activity == null) {
            return Collections.emptyList();
        }

        return gradeRepository.findByUserIDAndActivityIDAndDate(user, activity, date);
    }

    public Grade addGrade(Grade grade){
        Grade savedGrade = gradeRepository.save(grade);
        return savedGrade;
    }
}
