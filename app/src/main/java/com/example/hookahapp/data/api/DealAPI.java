package com.example.hookahapp.data.api;

import com.example.hookahapp.domain.entities.DealDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DealAPI {

    @GET("/promo")
    Call<List<DealDTO>> getAllDeals();

    @GET("/promo/{id}")
    Call<DealDTO> getDeal(@Path("id") int id);
}
