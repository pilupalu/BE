package com.group.services;

import com.group.entities.Team;
import com.group.repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeams() {
        List<Team> teams;
        teams = teamRepository.findAll();
        return teams;
    }

    public Team addTeam(Team team) {
        Team savedTeam = teamRepository.save(team);
        return savedTeam;
    }
}
