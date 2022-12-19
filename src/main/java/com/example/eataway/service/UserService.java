package com.example.eataway.service;

import com.example.eataway.dto.UserRegisterDTO;

public interface UserService {
    public void registerAndLogin(UserRegisterDTO userRegisterDTO);
}
