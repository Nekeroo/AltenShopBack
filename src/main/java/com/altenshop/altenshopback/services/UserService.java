package com.altenshop.altenshopback.services;

import com.altenshop.altenshopback.dto.RegisterInputDTO;
import com.altenshop.altenshopback.models.Role;
import com.altenshop.altenshopback.models.User;
import com.altenshop.altenshopback.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;

    private final RoleService roleService;

    public UserService(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository, RoleService roleService) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    public User registerNewUserAccount(RegisterInputDTO userInfos) {

        Role role = roleService.getRoleById(1);

        User user = User.builder()
                .username(userInfos.getUsername())
                .password(bCryptPasswordEncoder.encode(userInfos.getPassword()))
                .email(userInfos.getEmail())
                .roles(List.of(role))
                .build();

        return userRepository.save(user);
    }

    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }
}
