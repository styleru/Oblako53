package com.example.hookahapp;


import android.widget.TextView;

import com.arellomobile.mvp.MvpView;

public interface MainActivityVew extends MvpView {

    void menuButtonClicked(TextView textView);
    void dealButtonClicked(TextView textView);
    void cardButtonClicked(TextView textView);
    void parkingButtonClicked(TextView textView);
    void loadPhoto(String pictureUrl);

}
