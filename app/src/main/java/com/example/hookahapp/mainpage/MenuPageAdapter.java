package com.example.hookahapp.mainpage;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.hookahapp.mainpage.fragments.CardFragment;
import com.example.hookahapp.mainpage.fragments.DealFragment;
import com.example.hookahapp.mainpage.fragments.MenuFragment;
import com.example.hookahapp.mainpage.fragments.ParkingFragment;

public class MenuPageAdapter extends FragmentPagerAdapter {


    public MenuPageAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

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
