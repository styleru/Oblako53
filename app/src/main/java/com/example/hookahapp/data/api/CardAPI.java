package com.example.hookahapp.data.api;

import com.example.hookahapp.domain.entities.CardPercentReq;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CardAPI {
    @POST("http://Andrey1234.pythonanywhere.com/get_discount")
    Single<String> getCardDiscount(@Body CardPercentReq phone);
}
