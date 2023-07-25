package com.group.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.group.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
