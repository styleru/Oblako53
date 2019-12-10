package com.example.hookahapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import toothpick.Scope;
import toothpick.Toothpick;


public class MainActivity extends MvpAppCompatActivity implements MainActivityVew{


//    @Inject
    @InjectPresenter
    MainActivityPresenter presenter;

//    @Inject
    MenuPageAdapter menuPageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
//        Scope appScope = Toothpick.openScope(this);
//        Toothpick.inject(this, appScope);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);
        menuPageAdapter = new MenuPageAdapter(getSupportFragmentManager(), getApplicationContext());
        viewPager.setAdapter(menuPageAdapter);
        TextView deal = (TextView) findViewById(R.id.deal);
        deal.setOnClickListener(v -> {menuPageAdapter.getItem(1);
            deal.setTag(deal.getBackground());
            deal.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.menu_rectangle));});

    }

    @OnClick(R.id.deal)
    void dealButtonClicked(){
        TextView deal = (TextView) findViewById(R.id.deal);
        deal.setTag(deal.getBackground());
        deal.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.menu_rectangle));
        menuPageAdapter.getItem(1);

    }
}
