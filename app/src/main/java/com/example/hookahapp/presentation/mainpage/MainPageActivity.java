package com.example.hookahapp.presentation.mainpage;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bumptech.glide.Glide;
import com.example.hookahapp.App;
import com.example.hookahapp.R;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import toothpick.Scope;
import toothpick.Toothpick;


public class MainPageActivity extends MvpAppCompatActivity implements MainPageActivityVew {

    @Inject
    @InjectPresenter
    MainPageActivityPresenter presenter;

    MenuPageAdapter menuPageAdapter;

    @BindViews({R.id.menu, R.id.deal, R.id.card, R.id.parking}) List<TextView> headers;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.avatar_pic)
    ImageView avatarPic;

    @Inject
    Context appContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Scope appScope = Toothpick.openScope(App.class);
        Toothpick.inject(this, appScope);
        menuPageAdapter = new MenuPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(menuPageAdapter);
        viewPager.addOnPageChangeListener(new ViewPagerPageChangeListener(
                headers, appContext));
        loadPhoto(String.valueOf(R.drawable.avatar));
        headers.get(0).setBackground(getResources().getDrawable(R.drawable.menu_rectangle_pressed));
        viewPager.setCurrentItem(0);

    }


    @OnClick(R.id.menu)
    public void menuButtonClicked(TextView textView){
        viewPager.setCurrentItem(0, true);
    }

    @OnClick(R.id.deal)
    public void dealButtonClicked(TextView textView){
        viewPager.setCurrentItem(1, true);
    }

    @OnClick(R.id.card)
    public void cardButtonClicked(TextView textView){
        viewPager.setCurrentItem(2, true);
    }

    @OnClick(R.id.parking)
    public void parkingButtonClicked(TextView textView){
      viewPager.setCurrentItem(3, true);
    }

    @Override
    public void loadPhoto(String pictureUrl) {
        Glide.with(this)
                .load(R.drawable.avatar)
                .circleCrop()
                .into(avatarPic);
    }
}
