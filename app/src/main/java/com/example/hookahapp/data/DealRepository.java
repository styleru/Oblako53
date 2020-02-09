package com.example.hookahapp.data;

import com.example.hookahapp.data.api.DealAPI;
import com.example.hookahapp.domain.entities.DealDTO;
import com.example.hookahapp.domain.repository.IDealRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Retrofit;

public class DealRepository implements IDealRepository {


    private final SharedPreferencesRepository preferencesRepository;
    private final BasicAuthString basicAuthString;
    private DealAPI dealAPI;

    @Inject
    public DealRepository(SharedPreferencesRepository preferencesRepository,
                          BasicAuthString basicAuthString, Retrofit retrofit) {
        this.preferencesRepository = preferencesRepository;
        this.basicAuthString = basicAuthString;
        this.dealAPI = retrofit.create(DealAPI.class);
    }

    @Override
    public Single<List<DealDTO>> getAllDeals() {
        return dealAPI.getAllDeals(basicAuthString.getKey(
                preferencesRepository.getUsername(),
                preferencesRepository.getPassword()
        ));
    }

    @Override
    public Single<DealDTO> getDealById(int id) {
        return dealAPI.getDeal(basicAuthString.getKey(
                preferencesRepository.getUsername(),
                preferencesRepository.getPassword()
        ), id);
    }
}
