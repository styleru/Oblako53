package com.example.hookahapp;

import android.content.Intent;
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
        startActivity(new Intent(getApplicationContext(), RegistrationActivity1.class));
        finish();
    }
    @OnClick(R.id.enter_account)
    void enterAccountClicked(){
        startActivity(new Intent(getApplicationContext(), AuthorisationActivity.class));
        finish();
    }
}
