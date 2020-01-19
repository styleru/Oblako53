package com.example.hookahapp;

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
    }
}
