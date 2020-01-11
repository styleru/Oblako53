package com.example.hookahapp;

import android.app.Application;

import toothpick.Scope;
import toothpick.Toothpick;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Scope appScope = Toothpick.openScope(App.class);
        appScope.installModules(new PresentationModule(getApplicationContext()));
    }

}
