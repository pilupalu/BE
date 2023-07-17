package com.group.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.group.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
