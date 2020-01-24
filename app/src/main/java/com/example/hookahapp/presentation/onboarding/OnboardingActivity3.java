package com.example.hookahapp.presentation.onboarding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hookahapp.App;
import com.example.hookahapp.R;
import com.example.hookahapp.presentation.signing.RegOrAuthActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import toothpick.Toothpick;

public class OnboardingActivity3 extends AppCompatActivity {

    @Inject
    Context appContext;

    @Override
    public void onCreate(Bundle savedInstanceStated) {
        super.onCreate(savedInstanceStated);
        setContentView(R.layout.activity_onboarding_3);
        ButterKnife.bind(this);
        Toothpick.inject(this, Toothpick.openScope(App.class));
    }

    @OnClick(R.id.next_screen3)
    void nextScreenClicked(){
        startActivity(new Intent(appContext, RegOrAuthActivity.class));
        finish();
    }
}
