package com.example.hookahapp.presentation.mainpage;

import android.content.Context;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager.widget.ViewPager;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.hookahapp.App;
import com.example.hookahapp.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import toothpick.Scope;
import toothpick.Toothpick;


public class MainPageActivity extends MvpAppCompatActivity implements MainPageActivityVew {


    @InjectPresenter
    MainPageActivityPresenter presenter;

    @ProvidePresenter
    MainPageActivityPresenter getPresenter(){
        return  Toothpick.openScope(App.class).getInstance(MainPageActivityPresenter.class);
    }

    MenuPageAdapter menuPageAdapter;

    @BindViews({R.id.menu, R.id.deal, R.id.card, R.id.parking}) List<TextView> headers;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.mainpage_scrollview)
    ScrollView scrollView;

    @BindView(R.id.date)
    TextView date;

    @BindView(R.id.discount)
    TextView discount;

    @BindView(R.id.coordinator_layout_main)
    CoordinatorLayout coordinatorLayout;

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
        headers.get(0).setBackground(getResources().getDrawable(R.drawable.menu_rectangle_pressed));
        viewPager.setCurrentItem(0);
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, d MMMM");
        date.setText(sdf.format(new Date()));
        presenter.getDiscount();
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
    public void setDiscount(String discount) {
        this.discount.setText(this.discount.getText() + " " + discount);
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
