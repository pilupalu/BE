package com.group.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.group.entities.Team;

public interface TeamRepository extends JpaRepository<Team, Integer>{
}
