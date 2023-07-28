package com.group.services;

import com.group.entities.User;
import com.group.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllStudents() {
        List<User> users;
        users = userRepository.findAll();
        return users;
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public User addUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
