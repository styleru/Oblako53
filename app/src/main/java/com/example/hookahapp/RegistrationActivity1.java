package com.example.hookahapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.mikepenz.materialize.util.KeyboardUtil;

import butterknife.ButterKnife;

public class RegistrationActivity1 extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceStated) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceStated);
        setContentView(R.layout.activity_registration_1);
        ButterKnife.bind(this);
        KeyboardUtil keyboardUtil = new KeyboardUtil(this, findViewById(R.id.registration_1_layout));
        keyboardUtil.enable();
    }
}
