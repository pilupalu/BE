package com.group.controllers;

import com.group.entities.Team;
import com.group.repositories.TeamRepository;
import com.group.services.TeamService;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @PostMapping(value = "/newTeam")
    public ResponseEntity<Team> addTeam(@RequestBody Team team) {
        Team result = teamService.addTeam(team);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping(value = "/allTeams")
    public List<Team> getAllTeams() {
        return  teamService.getAllTeams();
    }
 }
