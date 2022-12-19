package com.example.eataway.mapper;

import com.example.eataway.dto.UserRegisterDTO;
import com.example.eataway.model.entity.User;

public class UserMapper {
    public User toUser(UserRegisterDTO dto) {
        return new User()
                .setEmail(dto.getEmail())
                .setName(dto.getName());
    }
}
