package com.example.hookahapp.presentation.mainpage.fragments.deal;

import com.arellomobile.mvp.MvpView;
import com.example.hookahapp.domain.entities.DealDTO;

import java.util.List;

public interface DealFragmentView extends MvpView {
    void addItems(List<DealDTO> deals);
}
