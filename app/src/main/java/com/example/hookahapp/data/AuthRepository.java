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

    private final BasicAuthString basicAuthString;
    private final SharedPreferencesRepository preferencesRepository;

    @Inject
    public AuthRepository(Retrofit retrofit, BasicAuthString basicAuthString,
                          SharedPreferencesRepository preferencesRepository) {
        this.userAPI = retrofit.create(UserAPI.class);
        this.basicAuthString = basicAuthString;
        this.preferencesRepository = preferencesRepository;
    }

    @Override
    public Single<UserDTOResponse> register(UserDTO userDTO) {
        return userAPI.registerUser(userDTO).doAfterSuccess(
                user -> preferencesRepository.saveUserInfo(user.getEmail(),
                        user.getPassword())
        );
    }

    @Override
    public Single<UserDTOResponse> getUserData() {
        return userAPI.getUserData(basicAuthString.getKey(
                preferencesRepository.getUsername(),
                preferencesRepository.getPassword()
        ));
    }

    @Override
    public Completable checkAuth(String username, String password) {
        return userAPI.getUserData(basicAuthString.getKey(username, password))
                .ignoreElement()
                .andThen(Completable.fromAction(()->
                        preferencesRepository.saveUserInfo(username, password)));
    }


}
