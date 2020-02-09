package com.example.hookahapp.presentation.mainpage.fragments.deal;

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
public class DealFragmentPresenter extends MvpPresenter<DealFragmentView> {

    private Interactor interactor;


    @Inject
    public DealFragmentPresenter(Interactor interactor){
        this.interactor = interactor;
    }

    void getDeals(){
        Disposable disposable = interactor.getAllDeals()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(deals -> getViewState().addItems(deals),
                        e -> {
                    if (BuildConfig.DEBUG)
                        Log.d("DealRequest", e.toString());
                        });
    }
}
