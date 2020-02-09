package com.example.hookahapp;

import com.example.hookahapp.data.AuthRepository;
import com.example.hookahapp.data.BasicAuthString;
import com.example.hookahapp.data.CardRepository;
import com.example.hookahapp.data.DealRepository;
import com.example.hookahapp.data.SharedPreferencesRepository;
import com.example.hookahapp.domain.repository.IAuthRepository;
import com.example.hookahapp.domain.repository.ICardRepository;
import com.example.hookahapp.domain.repository.IDealRepository;
import com.example.hookahapp.domain.repository.ISharedPreferencesRepository;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import toothpick.config.Module;

public class DataModule extends Module {
    public DataModule(){

        bind(Retrofit.class).toInstance(
                new Retrofit.Builder()
                    .baseUrl("http://80.211.245.129:5000")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build());

        bind(BasicAuthString.class).singletonInScope();

        bind(ISharedPreferencesRepository.class).to(SharedPreferencesRepository.class);
        bind(IAuthRepository.class).to(AuthRepository.class);
        bind(IDealRepository.class).to(DealRepository.class);
        bind(ICardRepository.class).to(CardRepository.class);
    }
}
