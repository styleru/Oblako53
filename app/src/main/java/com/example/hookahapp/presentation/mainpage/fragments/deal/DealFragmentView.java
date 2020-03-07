package com.example.hookahapp.presentation.mainpage.fragments.deal;

import androidx.annotation.StringRes;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.hookahapp.domain.entities.DealDTO;

import java.util.List;

public interface DealFragmentView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void replaceItems(List<DealDTO> deals);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setProgress(boolean visible);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showToast(@StringRes int text);
}
