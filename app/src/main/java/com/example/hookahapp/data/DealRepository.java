package com.example.hookahapp.data;

import android.content.SharedPreferences;

import com.example.hookahapp.data.api.DealAPI;
import com.example.hookahapp.domain.entities.DealDTO;
import com.example.hookahapp.domain.repository.IDealRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Retrofit;

public class DealRepository implements IDealRepository {

    @Inject
    SharedPreferences sharedPreferences;


    @Inject
    BasicAuthString basicAuthString;

    private DealAPI dealAPI;

    @Inject
    public DealRepository(Retrofit retrofit) {
        this.dealAPI = retrofit.create(DealAPI.class);
    }

    @Override
    public Single<List<DealDTO>> getAllDeals() {
        return dealAPI.getAllDeals(basicAuthString.getKey());
    }

    @Override
    public Single<DealDTO> getDealById(int id) {
        return dealAPI.getDeal(basicAuthString.getKey(), id);
    }
}
