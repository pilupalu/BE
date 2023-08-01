package com.group.repositories;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import com.group.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

        List<User> findAllByOrderByNameAsc();

        List<User> findAll(Specification<User> spec);

/*    List<Integer> findGradesById(Integer userId);*/
}
