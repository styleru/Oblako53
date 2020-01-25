package com.example.hookahapp.presentation.signing.authorisation;

import com.arellomobile.mvp.MvpView;

public interface AuthorisationActivityView extends MvpView {

    void backPressed();
    void continuePressed();
    void startMainActivity();
    void authorisationError();
}
