package com.example.hookahapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class OnboardingActivity3 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceStated) {
        super.onCreate(savedInstanceStated);
        setContentView(R.layout.activity_onboarding_3);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.next_screen3)
    void nextScreenClicked(){
        startActivity(new Intent(this, OnboardingActivity4.class));
        finish();
    }
}
