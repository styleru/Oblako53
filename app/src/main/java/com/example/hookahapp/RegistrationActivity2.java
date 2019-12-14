package com.example.hookahapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.mikepenz.materialize.util.KeyboardUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistrationActivity2 extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceStated) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceStated);
        setContentView(R.layout.activity_registration_2);
        ButterKnife.bind(this);
        KeyboardUtil keyboardUtil = new KeyboardUtil(this, findViewById(R.id.registration_layout_2));
        keyboardUtil.enable();
    }

    @OnClick(R.id.continue_registration_2)
    void continueClicked(){
        finish();
    }

    @OnClick(R.id.arrow_back_registration)
    void backArrowClicked(){
        startActivity(new Intent(this, RegistrationActivity1.class));
        finish();
    }
}