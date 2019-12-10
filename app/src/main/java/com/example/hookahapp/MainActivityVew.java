package com.example.hookahapp;


import android.widget.TextView;

import com.arellomobile.mvp.MvpView;

public interface MainActivityVew extends MvpView {
//    void headerClicked(TextView v);
    void menuButtonClicked();
    void dealButtonClicked();
    void cardButtonClicked();
    void parkingButtonClicked();
}
