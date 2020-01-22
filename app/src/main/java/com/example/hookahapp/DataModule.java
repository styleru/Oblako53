package com.example.hookahapp;

import com.example.hookahapp.data.AuthRepository;
import com.example.hookahapp.data.BasicAuthString;
import com.example.hookahapp.data.DealRepository;
import com.example.hookahapp.domain.repository.IAuthRepository;
import com.example.hookahapp.domain.repository.IDealRepository;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import toothpick.config.Module;

public class DataModule extends Module {
    public DataModule(){

        bind(Retrofit.class).toInstance(
                new Retrofit.Builder()
                    .baseUrl("http://80.211.245.129:5000")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build());

        bind(BasicAuthString.class).singletonInScope();

        bind(IAuthRepository.class).to(AuthRepository.class);
        bind(IDealRepository.class).to(DealRepository.class);
    }
}
