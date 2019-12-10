package com.example.hookahapp;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.w3c.dom.Text;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuPageAdapter extends FragmentPagerAdapter {

    private Context appContext;
//    private TextView menu, deal, card, parking;

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
                Log.d("bbbbbbbbb", "1");
                return MenuFragment.newInstance();
            }
            case 1:{
                Log.d("ccccccccccc", "1");
//                deal.setTag(deal.getBackground());
//                deal.setBackground(appContext.getResources().getDrawable(R.drawable.menu_rectangle));
                return DealFragment.newInstance(appContext);
            }
            case 2: return CardFragment.newInstance();
            case 3: return ParkingFragment.newInstance();
        }
        return null;
    }


    @Override
    public int getCount() {
        return 4;
    }
}
