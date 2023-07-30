package com.group.repositories;

import com.group.entities.Enrollment;
import com.group.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Enrollment.EnrollmentId> {
    List<Enrollment> findByTeamId(Team team);
}
