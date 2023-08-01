package com.group.repositories;

import com.group.entities.Activity;
import com.group.entities.Enrollment;
import com.group.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
}
