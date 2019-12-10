package com.example.hookahapp;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MenuPageAdapter extends FragmentPagerAdapter {

    private Context appContext;
//    @Inject
    MenuPageAdapter(FragmentManager fm, Context appContext) {
        super(fm);
        this.appContext = appContext;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:{

                Log.d("MenuPageAdapter", "0");
                return MenuFragment.newInstance();
            }
            case 1:{
                Log.d("MenuPageAdapter", "1");
                return DealFragment.newInstance(appContext);
            }
            case 2: {
                Log.d("MenuPageAdapter", "2");
                return CardFragment.newInstance();
            }
            case 3: {
                Log.d("MenuPageAdapter", "3");
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
