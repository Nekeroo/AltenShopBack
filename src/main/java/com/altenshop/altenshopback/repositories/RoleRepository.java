package com.altenshop.altenshopback.repositories;

import com.altenshop.altenshopback.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role getRoleById(int id);
}
