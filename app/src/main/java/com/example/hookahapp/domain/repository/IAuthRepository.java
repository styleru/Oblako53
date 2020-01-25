package com.example.hookahapp.domain.repository;

import com.example.hookahapp.domain.entities.UserDTO;
import com.example.hookahapp.domain.entities.UserDTOResponse;

import io.reactivex.Single;

public interface IAuthRepository {
    Single<UserDTOResponse> register(UserDTO userDTO);
    Single<UserDTOResponse> getUserData();
    Single<UserDTOResponse> checkAuth(String username, String password);
}
