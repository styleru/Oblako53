package com.example.hookahapp.data.api;

import com.example.hookahapp.domain.entities.UserDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserAPI {

    @POST("/auth/register")
    Call<UserDTO> registerUser(@Body UserDTO userDTO);

    @GET("/user/data")
    Call<UserDTO> getUserData();

    @DELETE("/user/delete")
    Call<UserDTO> deleteUser();

}
