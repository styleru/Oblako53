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
                .getDrawable(R.drawable.menu_rectangle));
    }

    @Override
    public void onPageSelected(int position) {
        clearMenuHeadersBackground();
        headers.get(position).setBackground(appContext.getResources()
                .getDrawable(R.drawable.menu_rectangle));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void clearMenuHeadersBackground(){
        headers.get(0).setBackground(null);
        headers.get(1).setBackground(null);
        headers.get(2).setBackground(null);
        headers.get(3).setBackground(null);
    }
}
