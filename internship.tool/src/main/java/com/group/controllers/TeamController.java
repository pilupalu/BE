package com.group.controllers;

import com.group.entities.Team;
import com.group.entities.User;
import com.group.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamRepository teamRepository;

    @PostMapping("/saveTeam")
    public String saveTeam(@RequestBody Team team){
        teamRepository.save(team);
        return "Team saved...";
    }

    @GetMapping("/getAllTeams")
    public List<Team> getAll(){
        return teamRepository.findAll();
    }
}
