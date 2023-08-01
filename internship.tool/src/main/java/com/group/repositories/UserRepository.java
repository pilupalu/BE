package com.group.repositories;

import com.group.entities.Role;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import com.group.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

        List<User> findAllByOrderByNameAsc();

        List<User> findAll(Specification<User> spec);

        @Query("SELECT u FROM User u WHERE u.id_team IS NULL AND u.role != :mentorRole")
        List<User> findUsersWithoutTeamExcludingMentors(@Param("mentorRole") Role mentorRole);

/*    List<Integer> findGradesById(Integer userId);*/
}
