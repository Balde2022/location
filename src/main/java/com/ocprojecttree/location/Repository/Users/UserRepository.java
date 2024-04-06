package com.ocprojecttree.location.Repository.Users;

import com.ocprojecttree.location.Models.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Long> {
    Optional<User> findByEmail(String email );
}
