package com.example.hookahapp;

import android.content.Context;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class ViewPagerPageChangeListener implements ViewPager.OnPageChangeListener {

    private List<TextView> headers;
    private Context appContext;

    ViewPagerPageChangeListener(List<TextView> headers, Context context){
        this.headers = headers;
        this.appContext = context;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        clearMenuHeadersBackground();
        headers.get(position).setBackground(appContext.getResources()
                .getDrawable(R.drawable.menu_rectangle_pressed));
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void clearMenuHeadersBackground(){
        headers.get(0).setBackground(appContext.getResources()
                .getDrawable(R.drawable.menu_rectangle_default));
        headers.get(1).setBackground(appContext.getResources()
                .getDrawable(R.drawable.menu_rectangle_default));
        headers.get(2).setBackground(appContext.getResources()
                .getDrawable(R.drawable.menu_rectangle_default));
        headers.get(3).setBackground(appContext.getResources()
                .getDrawable(R.drawable.menu_rectangle_default));
    }
}
