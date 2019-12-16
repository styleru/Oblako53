package com.example.hookahapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hookahapp.mainpage.MainPageActivity;
import com.example.hookahapp.onboarding.OnboardingActivity1;
import com.example.hookahapp.registration.RegOrAuthActivity;

import toothpick.Toothpick;

public class SplashActivity extends AppCompatActivity {

//    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toothpick.inject(this, Toothpick.openScope("App"));
        sharedPreferences = getApplicationContext()
                .getSharedPreferences("com.example.hookahapp.prefs", MODE_PRIVATE);

        if (sharedPreferences.getBoolean("firstrun", true)){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("firstrun", false);
            editor.apply();
            startActivity(new Intent(getApplicationContext(), OnboardingActivity1.class));
        }
        else
        {
            if(sharedPreferences.getBoolean("authed", false)){
                startActivity(new Intent(getApplicationContext(), MainPageActivity.class));

            }
            else{
                startActivityForResult(new Intent(getApplicationContext(),
                        RegOrAuthActivity.class), 1);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("authed", true);
            editor.apply();
            startActivity(new Intent(getApplicationContext(), MainPageActivity.class));
        }
    }
}
