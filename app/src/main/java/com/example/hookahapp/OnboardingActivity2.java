package com.example.hookahapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class OnboardingActivity2 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceStated) {
        super.onCreate(savedInstanceStated);
        setContentView(R.layout.activity_onboarding_2);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.next_screen2)
    void nextScreenClicked(){
        startActivity(new Intent(this, OnboardingActivity3.class));
        finish();
    }
}
