package com.example.hookahapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bumptech.glide.Glide;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import toothpick.Scope;
import toothpick.Toothpick;


public class MainActivity extends MvpAppCompatActivity implements MainActivityVew{

    @Inject
    @InjectPresenter
    MainActivityPresenter presenter;

    MenuPageAdapter menuPageAdapter;

    @BindViews({R.id.menu, R.id.deal, R.id.card, R.id.parking}) List<TextView> headers;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.avatar_pic)
    ImageView avatarPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, OnboardingActivity1.class));
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Scope appScore = Toothpick.openScope("App");
        Toothpick.inject(this, appScore);
        menuPageAdapter = new MenuPageAdapter(getSupportFragmentManager(), 0, getApplicationContext());
        viewPager.setAdapter(menuPageAdapter);
        viewPager.addOnPageChangeListener(new ViewPagerPageChangeListener(
                headers, getApplicationContext()));
        headers.get(0).setBackground(getResources().getDrawable(R.drawable.menu_rectangle_pressed));
        viewPager.setCurrentItem(0, false);

    }


    @OnClick(R.id.menu)
    public void menuButtonClicked(TextView textView){
        clearMenuHeadersBackground();
        textView.setBackground(getResources().getDrawable(R.drawable.menu_rectangle_pressed));
        viewPager.setCurrentItem(0, false);
    }

    @OnClick(R.id.deal)
    public void dealButtonClicked(TextView textView){
        clearMenuHeadersBackground();
        textView.setBackground(getResources().getDrawable(R.drawable.menu_rectangle_pressed));
        viewPager.setCurrentItem(1, false);
    }

    @OnClick(R.id.card)
    public void cardButtonClicked(TextView textView){
        clearMenuHeadersBackground();
        textView.setBackground(getResources().getDrawable(R.drawable.menu_rectangle_pressed));
        viewPager.setCurrentItem(2, false);
    }

    @OnClick(R.id.parking)
    public void parkingButtonClicked(TextView textView){
        clearMenuHeadersBackground();
        textView.setBackground(getResources().getDrawable(R.drawable.menu_rectangle_default));
        viewPager.setCurrentItem(3, false);
    }

    @Override
    public void loadPhoto(String pictureUrl) {
        Glide.with(this)
                .load(pictureUrl)
                .into(avatarPic);
    }

    private void clearMenuHeadersBackground(){
        headers.get(0).setBackground(getResources().getDrawable(R.drawable.menu_rectangle_default));
        headers.get(1).setBackground(getResources().getDrawable(R.drawable.menu_rectangle_default));
        headers.get(2).setBackground(getResources().getDrawable(R.drawable.menu_rectangle_default));
        headers.get(3).setBackground(getResources().getDrawable(R.drawable.menu_rectangle_default));
    }

}
