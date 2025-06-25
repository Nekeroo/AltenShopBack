package com.altenshop.altenshopback.mappers;

import com.altenshop.altenshopback.dto.UserDTO;
import com.altenshop.altenshopback.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final RoleMapper roleMapper;

    public UserMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    public UserDTO mapUserToUserDTO(User user, String token) {
        if (user == null) {
            return null;
        }

        return UserDTO.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .token(token)
                .roles(user.getRoles().stream().map(roleMapper::mapRoleToRoleDTO).toList())
                .build();
    }

}
