package com.group.controllers;

import com.group.entities.User;
import com.group.repositories.UserRepository;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/saveUser")
    public String saveUser(@RequestBody User user){
        userRepository.save(user);
        return "User saved...";
    }

    @GetMapping("/getAllUsers")
    public List<User> getAll(){
        return userRepository.findAll();
    }
}
