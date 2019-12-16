package com.example.hookahapp;

import android.content.Context;

import com.example.hookahapp.mainpage.fragments.DealRecyclerAdapter;

import toothpick.config.Module;

public class PresentationModule extends Module {

    public PresentationModule(Context context){
        bind(DealRecyclerAdapter.class)
                .singletonInScope();
//        SharedPreferences sharedPreferences = context
//                .getSharedPreferences("com.example.hookahapp.prefs", MODE_PRIVATE);
//        bind(SharedPreferences.class).toInstance(sharedPreferences);
    }
}
