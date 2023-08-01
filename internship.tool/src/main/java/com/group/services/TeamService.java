package com.group.services;

import com.group.entities.Activity;
import com.group.entities.Enrollment;
import com.group.entities.Team;
import com.group.exceptions.TeamNotFoundInActivity;
import com.group.repositories.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Team getTeamById(Integer teamId) {
        Optional<Team> optionalTeam = teamRepository.findById(teamId);
        return optionalTeam.orElse(null);
    }

}
