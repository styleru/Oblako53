package com.example.hookahapp.onboarding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hookahapp.R;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class OnboardingActivity2 extends AppCompatActivity {

    @Inject
    Context appContext;

    @Override
    public void onCreate(Bundle savedInstanceStated) {
        super.onCreate(savedInstanceStated);
        setContentView(R.layout.activity_onboarding_2);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.next_screen2)
    void nextScreenClicked(){
        startActivity(new Intent(appContext, OnboardingActivity3.class));
        finish();
    }
}
