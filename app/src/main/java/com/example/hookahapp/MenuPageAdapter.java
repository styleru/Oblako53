package com.example.hookahapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MenuPageAdapter extends FragmentPagerAdapter {

    private Context appContext;
    public MenuPageAdapter(@NonNull FragmentManager fm, int behavior, Context appContext) {
        super(fm, behavior);
        this.appContext = appContext;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:{
                return MenuFragment.newInstance();
            }
            case 1:{
                return DealFragment.newInstance();
            }
            case 2: {
                return CardFragment.newInstance();
            }
            case 3: {
                return ParkingFragment.newInstance();
            }
            default: return MenuFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
