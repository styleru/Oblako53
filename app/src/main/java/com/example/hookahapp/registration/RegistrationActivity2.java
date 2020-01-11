package com.example.hookahapp.registration;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hookahapp.R;
import com.mikepenz.materialize.util.KeyboardUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistrationActivity2 extends AppCompatActivity {

    @BindView(R.id.reg_password_edit)
    EditText passwordEdit;

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
        setResult(RESULT_OK, (new Intent()).putExtra("password", passwordEdit.getText()));
        finish();
    }

    @OnClick(R.id.arrow_back_registration)
    void backArrowClicked(){
        setResult(RESULT_CANCELED);
        finish();
    }
}