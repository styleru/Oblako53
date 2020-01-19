package com.example.hookahapp.data;

import com.example.hookahapp.data.api.UserAPI;
import com.example.hookahapp.domain.IAuthRepository;
import com.example.hookahapp.domain.entities.UserDTO;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AuthRepsitory implements IAuthRepository {

    private final Retrofit retrofit;


    @Inject
    public AuthRepsitory(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Override
    public void register(UserDTO userDTO) {

        UserAPI userAPI = retrofit.create(UserAPI.class);

        Call<UserDTO> call = userAPI.registerUser(userDTO);
        call.enqueue(new Callback<UserDTO>() {
            @Override
            public void onResponse(Call<UserDTO> call, Response<UserDTO> response) {

            }

            @Override
            public void onFailure(Call<UserDTO> call, Throwable t) {

            }
        });
    }

    @Override
    public void getUserData() {

        UserAPI userAPI = retrofit.create(UserAPI.class);
        Call<UserDTO> call = userAPI.getUserData();
        call.enqueue(new Callback<UserDTO>() {
            @Override
            public void onResponse(Call<UserDTO> call, Response<UserDTO> response) {

            }

            @Override
            public void onFailure(Call<UserDTO> call, Throwable t) {

            }
        });
    }
}
