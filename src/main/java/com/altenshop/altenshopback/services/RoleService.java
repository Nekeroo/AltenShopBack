package com.altenshop.altenshopback.services;

import com.altenshop.altenshopback.models.Role;
import com.altenshop.altenshopback.repositories.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getRoleById(int id) {
        return roleRepository.getRoleById(id);
    }
}
