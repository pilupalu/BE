package com.group.services;

import com.group.entities.Grade;
import com.group.repositories.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }
    public List<Grade> getAllGrades() {
        List<Grade> gradeList;
        gradeList = gradeRepository.findAll();
        return gradeList;
    }

    public Grade addGrade(Grade grade){
        Grade savedGrade = gradeRepository.save(grade);
        return savedGrade;
    }
}
