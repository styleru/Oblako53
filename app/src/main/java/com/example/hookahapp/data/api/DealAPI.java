package com.example.hookahapp.data.api;

import com.example.hookahapp.domain.entities.DealDTO;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface DealAPI {

    @GET("/promo")
    Single<List<DealDTO>> getAllDeals(@Header ("Authorization") String authKey);

    @GET("/promo/{id}")
    Single<DealDTO> getDeal(@Header ("Authorization") String authKey, @Path("id") int id);
}
