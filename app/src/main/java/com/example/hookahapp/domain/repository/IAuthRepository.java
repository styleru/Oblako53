package com.example.hookahapp.domain.repository;

import com.example.hookahapp.domain.entities.UserDTO;

import io.reactivex.Single;

public interface IAuthRepository {
    Single<UserDTO> register(UserDTO userDTO);
    Single<UserDTO> getUserData();
    Single<UserDTO> checkAuth(String username, String password);
}
