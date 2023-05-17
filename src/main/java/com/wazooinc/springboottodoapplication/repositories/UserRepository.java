package com.wazooinc.springboottodoapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wazooinc.springboottodoapplication.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
