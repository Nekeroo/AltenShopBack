package com.altenshop.altenshopback.mappers;

import com.altenshop.altenshopback.dto.RoleDTO;
import com.altenshop.altenshopback.models.Role;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleMapper {

    public RoleDTO mapRoleToRoleDTO(Role role) {
        if (role == null) {
            return null;
        }

        return RoleDTO.builder()
                .name(role.getName())
                .build();
    }

    public List<String> mapRoleToString(List<Role> roles) {
        if (roles == null) {
            return null;
        }

        return roles.stream()
                .map(Role::getName)
                .toList();
    }

}
