package com.example.hookahapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class OnboardingActivity4 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceStated) {
        super.onCreate(savedInstanceStated);
        setContentView(R.layout.activity_onboarding_4);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.register)
    void registerClicked(){
        finish();
    }
}
