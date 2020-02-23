package com.example.hookahapp.presentation.mainpage.fragments.card;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.hookahapp.App;
import com.example.hookahapp.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import toothpick.Toothpick;

public class CardFragment extends MvpAppCompatFragment implements CardFragmentView {

    @BindView(R.id.card_fragment_card_info)
    ConstraintLayout cardInfo;

    @BindView(R.id.card_fragment_discount)
    TextView discountText;

    @Inject
    Context appContext;

    @InjectPresenter
    CardFragmentPresenter presenter;

    @ProvidePresenter
    CardFragmentPresenter providePresenter(){
        return Toothpick.openScope(App.class).getInstance(CardFragmentPresenter.class);
    }

    public static CardFragment newInstance(){
        return new CardFragment();
    }

    public CardFragment() {}


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Toothpick.inject(this, Toothpick.openScope(App.class));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.card_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.getCardDiscount();
    }

    @Override
    public void onPause() {
        super.onPause();
        cardInfo.startAnimation(AnimationUtils.loadAnimation(appContext,
                R.anim.card_pop_down));
        cardInfo.setVisibility(View.INVISIBLE);

    }

    @OnClick(R.id.card_fragment_info)
    void infoClicked(){
        cardInfo.startAnimation(AnimationUtils.loadAnimation(appContext,
                R.anim.card_pop_up));
        cardInfo.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.card_root_screen)
    void rootClicked(){
        if (cardInfo.getVisibility() == View.VISIBLE) {
            cardInfo.startAnimation(AnimationUtils.loadAnimation(appContext,
                    R.anim.card_pop_down));
            cardInfo.setVisibility(View.INVISIBLE);
        }
    }

    public void setCardDiscount(String discount){
        discountText.setText(discount);
    }
}
