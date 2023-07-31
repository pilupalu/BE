package com.group.controllers;

import com.group.entities.Grade;
import com.group.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @PostMapping(value = "/newGrade")
    public ResponseEntity<Grade> addGrade(@RequestBody Grade grade) {
        Grade result = gradeService.addGrade(grade);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping
    public ResponseEntity<List<Grade>> getGradesForSession(
            @RequestParam("userId") int userId,
            @RequestParam("activityId") int activityId,
            @RequestParam("date") String date
    ) {
        List<Grade> grades = gradeService.getGradesByUserActivityAndDate(userId, activityId, date);
        if (grades.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(grades);
    }

    @GetMapping(value = "/allGrade")
    public List<Grade> getAllGrades(){
        return gradeService.getAllGrades();
    }
}
