package com.group.controllers;

import com.group.entities.Role;
import com.group.entities.User;
import com.group.repositories.UserRepository;
import com.group.services.UserService;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/newUser")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User result = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @GetMapping(value = "/allUsers")
    public List<User> getAllUsers(@RequestParam(defaultValue = "false", required = false) boolean sorted){
        return userService.getAllStudents(sorted);
    }

/*    @GetMapping(value = "/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username){
        User user = userService.getUserByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    @GetMapping
    public ResponseEntity<List<User>> getUsersByFields(@RequestParam(required = false) String username,
                                                       @RequestParam(required = false) String email,
                                                       @RequestParam(required = false) Role role,
                                                       @RequestParam(required = false) Integer teamId) {

        List<User> users = userService.getUsersByFields(username, email, role, teamId);

        if (users.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(users);
        }
    }

/*    @GetMapping("/{userId}/grades")
    public ResponseEntity<List<Integer>> getUserGrades(@PathVariable Integer userId) {
        List<Integer> grades = userService.getUserGrades(userId);

        if (grades.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(grades);
    }*/
}
