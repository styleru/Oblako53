package com.example.hookahapp.presentation.mainpage;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;


@InjectViewState
public class MainPageActivityPresenter extends MvpPresenter<MainPageActivityVew> {

    @Inject
    public MainPageActivityPresenter(){
    }
}
