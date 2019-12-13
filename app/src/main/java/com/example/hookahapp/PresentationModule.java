package com.example.hookahapp;

import android.content.Context;

import toothpick.config.Module;

public class PresentationModule extends Module {

    public PresentationModule(Context context){
        bind(DealRecyclerAdapter.class)
                .singletonInScope();
    }
}
