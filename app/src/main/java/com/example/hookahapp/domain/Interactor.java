package com.example.hookahapp.domain;

import com.example.hookahapp.domain.entities.DealDTO;
import com.example.hookahapp.domain.entities.UserDTO;
import com.example.hookahapp.domain.entities.UserDTOResponse;
import com.example.hookahapp.domain.repository.IAuthRepository;
import com.example.hookahapp.domain.repository.ICardRepository;
import com.example.hookahapp.domain.repository.IDealRepository;
import com.example.hookahapp.domain.repository.ISharedPreferencesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

public class Interactor{

    private IAuthRepository authRepository;
    private IDealRepository dealRepository;
    private ISharedPreferencesRepository sharedPreferencesRepository;
    private ICardRepository cardRepository;

    @Inject
    public Interactor(IAuthRepository authRepository, IDealRepository dealRepository,
                      ISharedPreferencesRepository sharedPreferencesRepository, ICardRepository cardRepository){
        this.authRepository = authRepository;
        this.dealRepository = dealRepository;
        this.sharedPreferencesRepository = sharedPreferencesRepository;
        this.cardRepository = cardRepository;
    }

    public Single<UserDTOResponse> registerUser(UserDTO userDTO){
        return authRepository.register(userDTO);
    }

    public Single<UserDTOResponse> getUserInfo(){
        return authRepository.getUserData();
    }

    public Single<List<DealDTO>> getAllDeals(){
        return dealRepository.getAllDeals();
    }

    public Single<DealDTO> getDealById(int id){
        return dealRepository.getDealById(id);
    }

    public Completable checkAuth(String username, String password){
        return authRepository.checkAuth(username, password);
    }

    public boolean firstRun(){
        return sharedPreferencesRepository.checkFirstRun();
    }

    public void saveFirstrun(){
        sharedPreferencesRepository.setNotFirstRun();
    }

    public boolean checkedAuthedOrNot(){
        return sharedPreferencesRepository.checkAuth();
    }

    public Single<String> getCardDisount(){
        return cardRepository.getCurrentDiscount();
    }

}
