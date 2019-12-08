package com.example.hookahapp;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MenuPageAdapter extends FragmentPagerAdapter {

    public MenuPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return MenuFragment.newInstance();
            case 1: return DealFragment.newInstance();
        }
        return null;
    }


    @Override
    public int getCount() {
        return 4;
    }
}
