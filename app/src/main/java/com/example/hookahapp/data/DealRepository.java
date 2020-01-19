package com.example.hookahapp.data;

import com.example.hookahapp.data.api.DealAPI;
import com.example.hookahapp.domain.IDealRepository;
import com.example.hookahapp.domain.entities.DealDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DealRepository implements IDealRepository {

    private final Retrofit retrofit;

    public DealRepository(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Override
    public void getAllDeals() {

        DealAPI dealAPI = retrofit.create(DealAPI.class);
        Call<List<DealDTO>> call = dealAPI.getAllDeals();
        call.enqueue(new Callback<List<DealDTO>>() {
            @Override
            public void onResponse(Call<List<DealDTO>> call, Response<List<DealDTO>> response) {

            }

            @Override
            public void onFailure(Call<List<DealDTO>> call, Throwable t) {

            }
        });
    }

    @Override
    public void getDealById(int id) {

        DealAPI dealAPI = retrofit.create(DealAPI.class);

        Call<DealDTO> call = dealAPI.getDeal(id);
        call.enqueue(new Callback<DealDTO>() {
            @Override
            public void onResponse(Call<DealDTO> call, Response<DealDTO> response) {

            }

            @Override
            public void onFailure(Call<DealDTO> call, Throwable t) {

            }
        });

    }
}
