package com.example.hookahapp.presentation.signing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hookahapp.App;
import com.example.hookahapp.R;
import com.example.hookahapp.presentation.authorisation.AuthorisationActivity;
import com.example.hookahapp.presentation.signing.registration.RegistrationActivity1;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import toothpick.Toothpick;

public class RegOrAuthActivity extends AppCompatActivity {

    @Inject
    Context appContext;

    @Override
    public void onCreate(Bundle savedInstanceStated) {
        super.onCreate(savedInstanceStated);
        setContentView(R.layout.activity_onboarding_4);
        ButterKnife.bind(this);
        Toothpick.inject(this, Toothpick.openScope(App.class));
    }

    @OnClick(R.id.register)
    public void registerClicked(){
        startActivity(new Intent(appContext, RegistrationActivity1.class));
        finish();
    }
    @OnClick(R.id.enter_account)
    public void enterAccountClicked(){
        startActivity(new Intent(appContext, AuthorisationActivity.class));
        finish();
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK) {
//            // TODO отправка данных о новом пользователе
//            setResult(RESULT_OK);
//            finish();
//        }
//    }
}
