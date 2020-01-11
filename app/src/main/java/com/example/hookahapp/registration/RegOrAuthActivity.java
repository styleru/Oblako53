package com.example.hookahapp.registration;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.hookahapp.R;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegOrAuthActivity extends MvpAppCompatActivity implements RegOrAuthActivityView {

    @Inject
    Context appContext;

    @Inject
    @InjectPresenter
    RegOrAuthActivityPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceStated) {
        super.onCreate(savedInstanceStated);
        setContentView(R.layout.activity_onboarding_4);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.register)
    public void registerClicked(){
        startActivityForResult(new Intent(appContext, RegistrationActivity1.class), 1);
    }
    @OnClick(R.id.enter_account)
    public void enterAccountClicked(){
        startActivityForResult(new Intent(appContext, AuthorisationActivity.class), 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            // TODO отправка данных о новом пользователе
            setResult(RESULT_OK, data);
            finish();
        }
    }
}
