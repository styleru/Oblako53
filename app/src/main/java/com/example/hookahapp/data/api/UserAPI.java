package com.example.hookahapp.data.api;

import com.example.hookahapp.domain.entities.UserDTO;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface UserAPI {

    @POST("/auth/register")
    Single<UserDTO> registerUser(@Body UserDTO userDTO);

    @GET("/user/data")
    Single<UserDTO> getUserData(@Header("Authorization") String authKey);

}
