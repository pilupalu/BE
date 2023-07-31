package com.group.repositories;

import com.group.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Grade.GradeID> {
    List<Grade> findByUserIDAndActivityIDAndDate(User user, Activity activity, String date);

    List<Grade> findByUserIDAndActivityID(User user, Activity activity);
}
