package com.group.controllers;

import com.group.entities.*;
import com.group.services.EnrollmentService;
import com.group.services.TeamService;
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
    private EnrollmentService enrollmentService;

    public TeamController(TeamService teamService, EnrollmentService enrollmentService) {
        this.teamService = teamService;
        this.enrollmentService = enrollmentService;
    }

    @PostMapping(value = "/newTeam")
    public ResponseEntity<Team> addTeam(@RequestBody Team team) {
        Team result = teamService.addTeam(team);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/{teamId}/activities")
    public ResponseEntity<List<Activity>> getActivitiesByTeam(@PathVariable Integer teamId) {
        // Assuming you have a method to fetch the team from the teamId
        Team team = teamService.getTeamById(teamId);
        if (team == null) {
            return ResponseEntity.notFound().build();
        }

        List<Activity> activities = enrollmentService.getActivityByTeam(team);
        return ResponseEntity.ok(activities);
    }

    @GetMapping(value = "/allTeams")
    public List<Team> getAllTeams() {
        return  teamService.getAllTeams();
    }

 }
