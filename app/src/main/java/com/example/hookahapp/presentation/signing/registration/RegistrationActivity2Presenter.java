package com.example.hookahapp.presentation.signing.registration;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.hookahapp.BuildConfig;
import com.example.hookahapp.domain.Interactor;
import com.example.hookahapp.domain.entities.UserDTO;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class RegistrationActivity2Presenter extends MvpPresenter<RegistrationActivity2View> {

    private Interactor interactor;

    @Inject
    public RegistrationActivity2Presenter(Interactor interactor){
        this.interactor = interactor;
    }

    void registerUser(String mail, String phone, String password){

        Disposable disposable = interactor.registerUser(new UserDTO(mail, phone, password))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        userDTO -> {
                            interactor.saveUserInfo(userDTO.getEmail(), userDTO.getPassword());
                            getViewState().startMainActivity();
                        },
                        e -> {
                            if (BuildConfig.DEBUG) Log.d("Registration User", e.toString());
                            getViewState().authorisationError();
                        });
    }
}
