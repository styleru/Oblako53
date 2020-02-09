package com.example.hookahapp.presentation.signing.authorisation;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.hookahapp.BuildConfig;
import com.example.hookahapp.domain.Interactor;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class AuthorisationActivityPresenter extends MvpPresenter<AuthorisationActivityView> {

    private Interactor interactor;

    @Inject
    public AuthorisationActivityPresenter(Interactor interactor){
        this.interactor = interactor;
    }

    public void regUser(String mail, String password){
        Disposable disposable = interactor.checkAuth(mail, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(()-> {
                    interactor.saveUserInfo(mail, password);
                    getViewState().startMainActivity();
                        },
                        e -> {
                    if (BuildConfig.DEBUG) Log.d("Checking Auth", e.toString());
                    getViewState().authorisationError();
                        });
    }
}
