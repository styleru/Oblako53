package com.example.hookahapp;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.hookahapp.mainpage.fragments.DealRecyclerAdapter;

import toothpick.config.Module;

import static android.content.Context.MODE_PRIVATE;

public class PresentationModule extends Module {

    public PresentationModule(Context context){
        bind(DealRecyclerAdapter.class)
                .singletonInScope();
        bind(Context.class).toInstance(context);
        SharedPreferences sharedPreferences = context
                .getSharedPreferences("com.example.hookahapp.prefs", MODE_PRIVATE);
        bind(SharedPreferences.class).toInstance(sharedPreferences);
    }


}
