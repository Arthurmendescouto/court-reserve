package com.example.court_reserve.repository;

import com.example.court_reserve.entity.Court;
import com.example.court_reserve.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<UserDetails> findUserByEmail(String email);
}
