package com.example.hookahapp.presentation.mainpage.fragments.deal;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.hookahapp.R;
import com.example.hookahapp.domain.Interactor;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class DealFragmentPresenter extends MvpPresenter<DealFragmentView> {

    private Interactor interactor;


    @Inject
    public DealFragmentPresenter(Interactor interactor) {
        this.interactor = interactor;
    }

    void getDeals() {
        Disposable disposable = interactor.getAllDeals()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> getViewState().setProgress(false))
                .subscribe(deals -> {
                            getViewState().replaceItems(deals);
                        },
                        e -> {
                                getViewState().showToast(R.string.network_error);
                                getViewState().replaceItems(new ArrayList<>());
                        });
    }
}
