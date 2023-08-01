package com.group.services;

import com.group.entities.Role;
import com.group.entities.Team;
import com.group.entities.User;
import com.group.exceptions.InvalidTeamLeaderException;
import com.group.exceptions.TeamNotFoundException;
import com.group.exceptions.UserNotFound;
import com.group.repositories.TeamRepository;
import com.group.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final UserRepository userRepository;

    public TeamService(TeamRepository teamRepository, UserRepository userRepository) {
        this.teamRepository = teamRepository;
        this.userRepository = userRepository;
    }

    public List<Team> getAllTeams() {
        List<Team> teams;
        teams = teamRepository.findAll();
        return teams;
    }

    public Team addTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team getTeamById(Integer teamId) {
        Optional<Team> optionalTeam = teamRepository.findById(teamId);
        return optionalTeam.orElse(null);
    }

    public Team updateTeamLeader(int teamId, int newLeaderId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new TeamNotFoundException(HttpStatus.NOT_FOUND));

        User newLeader = userRepository.findById(newLeaderId)
                .orElseThrow(() -> new UserNotFound(HttpStatus.NOT_FOUND));

        if (newLeader.getRole() == Role.MENTOR) {
            throw new InvalidTeamLeaderException("A user with the role 'MENTOR' cannot be a team leader.");
        }

        if (newLeader.getId_team() == null || newLeader.getId_team().getId_team() != teamId) {
            throw new InvalidTeamLeaderException("The new leader must be a member of the same team.");
        }



        team.setId_leader(newLeader);
        return teamRepository.save(team);
    }

}
