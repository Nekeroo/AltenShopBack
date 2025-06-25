package com.altenshop.altenshopback.controllers;

import com.altenshop.altenshopback.config.jwt.JwtTokenProvider;
import com.altenshop.altenshopback.dto.LoginInputDTO;
import com.altenshop.altenshopback.dto.RegisterInputDTO;
import com.altenshop.altenshopback.dto.UserDTO;
import com.altenshop.altenshopback.mappers.RoleMapper;
import com.altenshop.altenshopback.mappers.UserMapper;
import com.altenshop.altenshopback.models.Role;
import com.altenshop.altenshopback.models.User;
import com.altenshop.altenshopback.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthentificationController {

    private final RoleMapper roleMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;
    private final UserMapper userMapper;

    public AuthentificationController(RoleMapper roleMapper, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService, UserMapper userMapper) {
        this.roleMapper = roleMapper;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/token")
    public ResponseEntity<?> login(@RequestBody LoginInputDTO loginInputDTO) {
        try {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginInputDTO.getEmail(), loginInputDTO.getPassword());
            Authentication authentication = authenticationManager.authenticate(authToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String userName = loginInputDTO.getEmail();
            User user = userService.getUser(loginInputDTO.getEmail());

            String token = jwtTokenProvider.generateToken(userName, roleMapper.mapRoleToString(user.getRoles()));

            UserDTO userDTO = userMapper.mapUserToUserDTO(user, token);
            return ResponseEntity.ok().body(userDTO);
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().body("Invalid username or password");
        }
    }

    @PostMapping("/account")
    public ResponseEntity<?> register(@RequestBody RegisterInputDTO registerInputDTO) {
        if (userService.getUser(registerInputDTO.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Email already taken");
        }

        User user = userService.registerNewUserAccount(registerInputDTO);

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(registerInputDTO.getEmail(), registerInputDTO.getPassword());
        Authentication authentication = authenticationManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(user.getUsername(), user.getRoles().stream().map(Role::getName).collect(Collectors.toList()));

        UserDTO userDTO = userMapper.mapUserToUserDTO(user, token);
        return ResponseEntity.ok().body(userDTO);
    }


}
