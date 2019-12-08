package com.example.hookahapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.arellomobile.mvp.MvpAppCompatFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DealFragment extends Fragment {


    public static DealFragment newInstance(){
        return new DealFragment();
    }

    public DealFragment() {}

    @BindView(R.id.deal)
    TextView deal;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.deal_fragment, container, false);
        ButterKnife.bind(this, view);
        deal.setTag(deal.getBackground());
        deal.setBackground(getResources().getDrawable(R.drawable.menu_rectangle));
        return view;
    }

    @Override
    public void onDestroyView() {
        deal.setBackground((Drawable)deal.getTag());
        super.onDestroyView();

    }
}
