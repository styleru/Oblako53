package com.example.hookahapp.presentation.mainpage.fragments.card;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.hookahapp.domain.Interactor;

import javax.inject.Inject;

@InjectViewState
public class CardFragmentPresenter extends MvpPresenter<CardFragmentView> {

    private Interactor interactor;

    @Inject
    CardFragmentPresenter(Interactor interactor){
        this.interactor = interactor;
    }
}
