package com.example.hookahapp.data;

import com.example.hookahapp.data.api.UserAPI;
import com.example.hookahapp.domain.entities.UserDTO;
import com.example.hookahapp.domain.entities.UserDTOResponse;
import com.example.hookahapp.domain.repository.IAuthRepository;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import retrofit2.Retrofit;

public class AuthRepository implements IAuthRepository {

    private final UserAPI userAPI;

    @Inject
    BasicAuthStringRepository basicAuthStringRepository;

    @Inject
    public AuthRepository(Retrofit retrofit) {
        this.userAPI = retrofit.create(UserAPI.class);
    }

    @Override
    public Single<UserDTOResponse> register(UserDTO userDTO) {
        return userAPI.registerUser(userDTO);
    }

    @Override
    public Single<UserDTOResponse> getUserData(String key) {
        return userAPI.getUserData(key);
    }

    @Override
    public Completable checkAuth(String username, String password) {
        return userAPI.getUserData(basicAuthStringRepository.createKeyFromString(username, password))
                .ignoreElement()
                .andThen(Completable.fromAction(()->{}));
    }


}
