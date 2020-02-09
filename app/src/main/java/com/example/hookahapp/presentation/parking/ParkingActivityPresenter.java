package com.example.hookahapp.presentation.parking;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.regex.Pattern;

import javax.inject.Inject;

@InjectViewState
public class ParkingActivityPresenter extends MvpPresenter<ParkingActivityView> {

    @Inject
    public ParkingActivityPresenter(){}


    void checkStrings(String curNumber, String name){
        if (!Pattern.compile("[а-я]\\d{3}[а-я]{2}\\d{2,3}")
                .matcher(curNumber).find()) getViewState().showToast("Номер введен некорректно");
        else if (!Pattern.compile("[а-яА-Я]+\\s[а-яА-Я]+")
                .matcher(name).find()) getViewState().showToast("Имя и фамилия введены некорректно");
        else getViewState().successParking();
    }
}
