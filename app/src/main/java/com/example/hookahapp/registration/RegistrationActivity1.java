package com.example.hookahapp.registration;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hookahapp.R;
import com.mikepenz.materialize.util.KeyboardUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

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

    @OnClick(R.id.continue_registration_1)
    void continueClicked(){
        startActivityForResult(new Intent(getApplicationContext(), RegistrationActivity2.class), 1);
    }

    @OnClick(R.id.close_cross_registration)
    void crossClicked(){
        setResult(RESULT_CANCELED);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            setResult(RESULT_OK);
            finish();
        }
    }
}
