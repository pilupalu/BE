package com.group.services;

import com.group.entities.Role;
import com.group.entities.User;
import com.group.repositories.UserRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllStudents(boolean sorted) {
        List<User> users;
        if(sorted) users = userRepository.findAllByOrderByUsernameAsc();
        else users = userRepository.findAll();
        return users;
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public User addUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public List<User> getUsersByFields(String username, String email, Role role, Integer teamId) {

        Specification<User> spec = Specification.where(null);

        if (username != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("username"), username));
        }

        if (email != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("email"), email));
        }

        if (role != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("role"), role));
        }

        if (teamId != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("team").get("id"), teamId));
        }

        return userRepository.findAll(spec);
    }

    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
