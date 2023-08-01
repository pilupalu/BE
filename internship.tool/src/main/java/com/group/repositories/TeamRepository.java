package com.group.repositories;

import com.group.entities.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import com.group.entities.Team;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
}
