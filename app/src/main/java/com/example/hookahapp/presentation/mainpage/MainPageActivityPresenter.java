package com.example.hookahapp.presentation.mainpage;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.hookahapp.domain.Interactor;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


@InjectViewState
public class MainPageActivityPresenter extends MvpPresenter<MainPageActivityVew> {

    private Interactor interactor;

    @Inject
    public MainPageActivityPresenter(Interactor interactor){
        this.interactor = interactor;
    }

    void getDiscount(){
        Disposable disposable = interactor.getCardDisount()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(discount -> getViewState().setDiscount(discount),
                        e -> {});
    }
}
