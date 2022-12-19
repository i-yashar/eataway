package com.example.eataway.service.impl;

import com.example.eataway.dto.UserRegisterDTO;
import com.example.eataway.mapper.UserMapper;
import com.example.eataway.model.entity.User;
import com.example.eataway.model.entity.UserRole;
import com.example.eataway.model.entity.enums.UserRoleEnum;
import com.example.eataway.repository.UserRepository;
import com.example.eataway.repository.UserRoleRepository;
import com.example.eataway.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    private final UserMapper userMapper = new UserMapper();

    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    public void registerAndLogin(UserRegisterDTO userRegisterDTO) {
        User user = userMapper.toUser(userRegisterDTO);
        UserRole userRole = this.userRoleRepository.findByUserRoleLike(UserRoleEnum.USER).get();

        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        user.setUserRoles(new HashSet<>());
        user.getUserRoles().add(userRole);

        userRepository.save(user);
        login(user);
    }

    private void login(User user) {
        UserDetails userDetails = userDetailsService
                .loadUserByUsername(user.getEmail());

        Authentication authentication =
                new UsernamePasswordAuthenticationToken(
                        userDetails,
                        userDetails.getPassword(),
                        userDetails.getAuthorities()
                );

        SecurityContextHolder
                .getContext()
                .setAuthentication(authentication);
    }
}
