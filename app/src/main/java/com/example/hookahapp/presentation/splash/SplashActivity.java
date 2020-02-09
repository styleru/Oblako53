package com.example.hookahapp.presentation.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.hookahapp.App;
import com.example.hookahapp.presentation.mainpage.MainPageActivity;
import com.example.hookahapp.presentation.onboarding.OnboardingActivity1;
import com.example.hookahapp.presentation.signing.RegOrAuthActivity;

import javax.inject.Inject;

import toothpick.Toothpick;

public class SplashActivity extends MvpAppCompatActivity implements SplashActivityView{

    @InjectPresenter
    SplashActivityPresenter presenter;

    @ProvidePresenter
    SplashActivityPresenter providePresenter(){
        return Toothpick.openScope(App.class).getInstance(SplashActivityPresenter.class);
    }

    @Inject
    Context appContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toothpick.inject(this, Toothpick.openScope(App.class));
        presenter.chooseActivity();
    }


    @Override
    public void startOnBoarding() {
        startActivity(new Intent(appContext, OnboardingActivity1.class));
        finish();
    }

    @Override
    public void startMain() {
        startActivity(new Intent(appContext, MainPageActivity.class));
        finish();
    }

    @Override
    public void startRegAuth() {
        startActivity(new Intent(appContext, RegOrAuthActivity.class));
        finish();

    }
}
