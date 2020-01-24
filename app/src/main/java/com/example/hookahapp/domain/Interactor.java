package com.example.hookahapp.domain;

import com.example.hookahapp.domain.entities.DealDTO;
import com.example.hookahapp.domain.entities.UserDTO;
import com.example.hookahapp.domain.repository.IAuthRepository;
import com.example.hookahapp.domain.repository.IDealRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class Interactor{

    private IAuthRepository authRepository;
    private IDealRepository dealRepository;

    @Inject
    public Interactor(IAuthRepository authRepository, IDealRepository dealRepository){
        this.authRepository = authRepository;
        this.dealRepository = dealRepository;
    }

    public Single<UserDTO> registerUser(UserDTO userDTO){
        return authRepository.register(userDTO);
    }

    public Single<UserDTO> getUserInfo(){
        return authRepository.getUserData();
    }

    public Single<List<DealDTO>> getAllDeals(){
        return dealRepository.getAllDeals();
    }

    public Single<DealDTO> getDealById(int id){
        return dealRepository.getDealById(id);
    }

    public Single<UserDTO> checkAuth(String username, String password){
        return authRepository.checkAuth(username, password);
    }

}
