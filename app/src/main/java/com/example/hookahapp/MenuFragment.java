package com.example.hookahapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuFragment extends Fragment {


    public static DealFragment newInstance(){
        return new DealFragment();
    }

    public MenuFragment() {}

    @BindView(R.id.menu)
    TextView menu;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        menu.setTag(menu.getBackground());
        menu.setBackground(getResources().getDrawable(R.drawable.menu_rectangle));
        View view = inflater.inflate(R.layout.deal_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        menu.setBackground((Drawable) menu.getTag());
        super.onDestroyView();

    }
}