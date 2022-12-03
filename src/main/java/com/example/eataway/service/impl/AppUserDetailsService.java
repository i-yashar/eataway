package com.example.eataway.service.impl;

import com.example.eataway.model.entity.User;
import com.example.eataway.model.entity.UserRole;
import com.example.eataway.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.stream.Collectors;

public class AppUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.userRepository
                .findByEmail(email)
                .map(this::mapToUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " not found!"));
    }

    private UserDetails mapToUserDetails(User user) {
        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(user
                        .getUserRoles()
                        .stream()
                        .map(this::mapToGrantedAuthority)
                        .collect(Collectors.toList()))
                .build();
    }

    private GrantedAuthority mapToGrantedAuthority(UserRole userRole) {
        return new SimpleGrantedAuthority("ROLE_" +
                userRole
                        .getUserRole()
                        .name()
        );
    }
}
