package com.example.hookahapp.registration;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hookahapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegOrAuthActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceStated) {
        super.onCreate(savedInstanceStated);
        setContentView(R.layout.activity_onboarding_4);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.register)
    void registerClicked(){
        startActivityForResult(new Intent(getApplicationContext(), RegistrationActivity1.class), 1);
    }
    @OnClick(R.id.enter_account)
    void enterAccountClicked(){
        startActivityForResult(new Intent(getApplicationContext(), AuthorisationActivity.class), 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            setResult(RESULT_OK);
            finish();
        }
    }
}
