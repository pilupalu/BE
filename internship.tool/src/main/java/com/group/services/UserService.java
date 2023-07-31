package com.group.services;

import com.group.entities.Role;
import com.group.entities.User;
import com.group.exceptions.UserNotFound;
import com.group.repositories.UserRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
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

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsersByFields(Integer id, String username, String email, Role role, Integer teamId) {
        // Create a specification to dynamically filter the users
        Specification<User> spec = Specification.where(null);

        if(id != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id));
        }

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

        List<User> users = userRepository.findAll(spec);

        if (users.isEmpty()) {
            throw new UserNotFound(HttpStatus.NOT_FOUND);
        }

        return userRepository.findAll(spec);
    }

    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFound(HttpStatus.NOT_FOUND));
    }
/*    public List<Integer> getUserGrades(Integer userId) {
        return userRepository.findGradesById(userId);
    }*/
}
