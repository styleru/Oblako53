package com.example.hookahapp;

import android.content.Context;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MenuPageAdapter extends FragmentPagerAdapter {

    private Context appContext;
    private TextView menu, deal, card, parking;

//    @Inject
    MenuPageAdapter(FragmentManager fm, Context appContext) {
        super(fm);
        this.appContext = appContext;
    }



    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:{
//                menu.setTag(deal.getBackground());
//                menu.setBackground(appContext.getResources().getDrawable(R.drawable.menu_rectangle));
                return MenuFragment.newInstance();
            }
            case 1:{
//                deal.setTag(deal.getBackground());
//                deal.setBackground(appContext.getResources().getDrawable(R.drawable.menu_rectangle));
                return DealFragment.newInstance(appContext);
            }
            case 2: return MenuFragment.newInstance();
            case 3: return MenuFragment.newInstance();
            default: return MenuFragment.newInstance();
        }
    }


    @Override
    public int getCount() {
        return 4;
    }
}
