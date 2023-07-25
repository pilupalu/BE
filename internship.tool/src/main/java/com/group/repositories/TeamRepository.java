package com.group.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.group.entities.Team;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

}
