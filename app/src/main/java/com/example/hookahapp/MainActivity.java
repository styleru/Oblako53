package com.example.hookahapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;


import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends MvpAppCompatActivity implements MainActivityVew{


//    @Inject
    @InjectPresenter
    MainActivityPresenter presenter;

//    @Inject
    MenuPageAdapter menuPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Scope appScope = Toothpick.openScope(this);
//        Toothpick.inject(this, appScope);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ViewPager viewPager = findViewById(R.id.viewPager);
        menuPageAdapter = new MenuPageAdapter(getSupportFragmentManager(), getApplicationContext());
        viewPager.setAdapter(menuPageAdapter);
        viewPager.setCurrentItem(0);
        TextView deal = findViewById(R.id.deal);
        deal.setOnClickListener(v -> {menuPageAdapter.getItem(1);
            deal.setTag(deal.getBackground());
            deal.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.menu_rectangle));});

    }

//    @OnClick(R.id.deal)
//    public void dealButtonClicked(){
//        Log.d("aaaaaa", "1");
//        TextView deal = findViewById(R.id.deal);
//        deal.setTag(deal.getBackground());
//        deal.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.menu_rectangle));
//        menuPageAdapter.getItem(1);
//
//    }
}
