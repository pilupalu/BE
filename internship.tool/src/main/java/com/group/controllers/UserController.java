package com.group.controllers;

import com.group.entities.Role;
import com.group.entities.User;

import com.group.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/all")
    public List<User> getAllUsers(@RequestParam(defaultValue = "false", required = false) boolean sorted){
        return userService.getAllStudents(sorted);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsersByFields(@RequestParam(required = false) Integer id,
                                                       @RequestParam(required = false) String name,
                                                       @RequestParam(required = false) String email,
                                                       @RequestParam(required = false) Role role,
                                                       @RequestParam(required = false) Integer teamId) {

        List<User> users = userService.getUsersByFields(id, name, email, role, teamId);

        if (users.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(users);
        }
    }

    @GetMapping("/withoutTeam")
    public ResponseEntity<List<User>> getUsersWithoutTeam() {
        List<User> users = userService.getUsersWithoutTeam();
        return ResponseEntity.ok(users);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<User> putUserTeam(@PathVariable int userId, @RequestParam int teamId) {
        User user = userService.putUserTeam(userId, teamId);
        return ResponseEntity.ok(user);
    }
}
