package com.example.hookahapp.presentation.mainpage.fragments.card;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.hookahapp.domain.Interactor;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class CardFragmentPresenter extends MvpPresenter<CardFragmentView> {

    private Interactor interactor;

    @Inject
    CardFragmentPresenter(Interactor interactor){
        this.interactor = interactor;
    }

    void getCardDiscount(){
        Disposable disposable = interactor.getCardDisount()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(discount -> getViewState().setCardDiscount(discount),
                        e -> {});
    }
}
