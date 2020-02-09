package com.example.hookahapp.presentation.splash;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.hookahapp.domain.Interactor;

import javax.inject.Inject;

@InjectViewState
public class SplashActivityPresenter extends MvpPresenter<SplashActivityView> {

    private Interactor interactor;

    @Inject
    SplashActivityPresenter(Interactor interactor){
        this.interactor = interactor;
    }

    void chooseActivity(){
        if (interactor.firstRun()) {
            interactor.saveFirstrun();
            getViewState().startOnBoarding();
        }
        else if(interactor.checkedAuthedOrNot()){
            getViewState().startMain();
        }
        else getViewState().startRegAuth();
    }

}
