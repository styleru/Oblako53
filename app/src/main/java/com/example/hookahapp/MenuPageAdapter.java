package com.example.hookahapp;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MenuPageAdapter extends FragmentPagerAdapter {

    private Context appContext;
    private TextView menu, deal, card, parking;

//    @Inject
    MenuPageAdapter(FragmentManager fm, Context appContext, ArrayList<TextView> headers) {
        super(fm);
        this.menu = headers.get(0);
        this.deal = headers.get(1);
        this.card = headers.get(2);
        this.parking = headers.get(3);
        this.appContext = appContext;
    }



    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:{
                clearTextViewsBackground();
                this.menu.setBackground(appContext.getResources().getDrawable(R.drawable.menu_rectangle));
                Log.d("MenuPageAdapter", "0");
                return MenuFragment.newInstance();
            }
            case 1:{
                clearTextViewsBackground();
                Log.d("MenuPageAdapter", "1");
                this.deal.setBackground(appContext.getResources().getDrawable(R.drawable.menu_rectangle));
                return DealFragment.newInstance(appContext);
            }
            case 2: {
                clearTextViewsBackground();
                this.card.setBackground(appContext.getResources().getDrawable(R.drawable.menu_rectangle));
                Log.d("MenuPageAdapter", "2");
                return CardFragment.newInstance();
            }
            case 3: {
                clearTextViewsBackground();
                this.parking.setBackground(appContext.getResources().getDrawable(R.drawable.menu_rectangle));
                Log.d("MenuPageAdapter", "3");
                return ParkingFragment.newInstance();
            }
            default: return MenuFragment.newInstance();
        }
    }

    private void clearTextViewsBackground(){
        this.menu.setBackground(null);
        this.deal.setBackground(null);
        this.card.setBackground(null);
        this.parking.setBackground(null);
    }
    @Override
    public int getCount() {
        return 4;
    }
}
