package com.altenshop.altenshopback.services;

import com.altenshop.altenshopback.models.CustomUserDetails;
import com.altenshop.altenshopback.models.User;
import com.altenshop.altenshopback.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if (user==null) {
            throw new UsernameNotFoundException(email);
        }

        return new CustomUserDetails(user);
    }
}
