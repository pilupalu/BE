package com.group.controllers;

import com.group.entities.Role;
import com.group.entities.User;

import com.group.services.UserService;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/new")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User result = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @GetMapping(value = "/all")
    public List<User> getAllUsers(@RequestParam(defaultValue = "false", required = false) boolean sorted){
        return userService.getAllStudents(sorted);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsersByFields(@RequestParam(required = false) Integer id,
                                                       @RequestParam(required = false) String username,
                                                       @RequestParam(required = false) String email,
                                                       @RequestParam(required = false) Role role,
                                                       @RequestParam(required = false) Integer teamId) {

        List<User> users = userService.getUsersByFields(id, username, email, role, teamId);

        if (users.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(users);
        }
    }

}
