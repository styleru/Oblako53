package com.example.hookahapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hookahapp.presentation.mainpage.MainPageActivity;
import com.example.hookahapp.presentation.onboarding.OnboardingActivity1;
import com.example.hookahapp.presentation.signing.RegOrAuthActivity;

import javax.inject.Inject;

import toothpick.Toothpick;

public class SplashActivity extends AppCompatActivity {

    @Inject
    SharedPreferences sharedPreferences;
    
    @Inject
    Context appContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toothpick.inject(this, Toothpick.openScope(App.class));

        if (sharedPreferences.getBoolean("firstrun", true)){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("firstrun", false);
            editor.apply();
            startActivity(new Intent(appContext, OnboardingActivity1.class));
        }
        else
        {
            if(sharedPreferences.getBoolean("authed", false)){
                startActivity(new Intent(appContext, MainPageActivity.class));

            }
            else{
                startActivity(new Intent(appContext,
                        RegOrAuthActivity.class));
            }
        }
    }
}
