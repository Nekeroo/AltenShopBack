package com.altenshop.altenshopback.repositories;

import com.altenshop.altenshopback.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
