package com.example.hookahapp.domain;

import com.example.hookahapp.domain.entities.UserDTO;

public interface IAuthRepository {
    void register(UserDTO userDTO);
    void getUserData();
}
