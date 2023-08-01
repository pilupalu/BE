package com.group.repositories;

import com.group.entities.Activity;
import com.group.entities.Enrollment;
import com.group.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Enrollment.EnrollmentId> {
    @Query("SELECT e FROM Enrollment e WHERE e.id_team = :team")
    List<Enrollment> findByTeamId(Team team);
    @Query("SELECT e FROM Enrollment e WHERE e.id_activity = :activity")
    List<Enrollment> findByActivityId(Activity activity);
}
