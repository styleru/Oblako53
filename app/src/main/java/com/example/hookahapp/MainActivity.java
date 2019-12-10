package com.example.hookahapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;


import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends MvpAppCompatActivity implements MainActivityVew{


//    @Inject
    @InjectPresenter
    MainActivityPresenter presenter;

//    @Inject
    MenuPageAdapter menuPageAdapter;

    @BindViews({R.id.menu, R.id.deal, R.id.card, R.id.parking}) List<TextView> headers;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Scope appScope = Toothpick.openScope(this);
//        Toothpick.inject(this, appScope);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        TextView deal = findViewById(R.id.deal);
//        TextView[] tmp = {findViewById(R.id.menu), deal, findViewById(R.id.card),
//                findViewById(R.id.parking)};
//        new ArrayList<TextView>(Arrays.asList(tmp))
        menuPageAdapter = new MenuPageAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(menuPageAdapter);
        viewPager.addOnPageChangeListener(new ViewPagerPageChangeListener(
//                new ArrayList<TextView>(Arrays.asList(tmp)), this
                headers, this
        ));
        viewPager.setCurrentItem(0);
    }

//    @OnClick({R.id.menu, R.id.deal, R.id.card, R.id.parking})
//    public void headerClicked(TextView v){
//        Log.d("headerClicked", String.valueOf(v.getId()));
//
//        switch (v.getId()){
//            case R.id.menu: viewPager.setCurrentItem(0);
//            case R.id.deal: viewPager.setCurrentItem(1);
//            case R.id.card: viewPager.setCurrentItem(2);
//            case R.id.parking: viewPager.setCurrentItem(3);
//        }
//    }

    @OnClick(R.id.menu)
    public void menuButtonClicked(){
        viewPager.setCurrentItem(0);
    }

    @OnClick(R.id.deal)
    public void dealButtonClicked(){
        viewPager.setCurrentItem(1);
    }

    @OnClick(R.id.card)
    public void cardButtonClicked(){
        viewPager.setCurrentItem(2);
    }

    @OnClick(R.id.parking)
    public void parkingButtonClicked(){
        viewPager.setCurrentItem(3);
    }

}
