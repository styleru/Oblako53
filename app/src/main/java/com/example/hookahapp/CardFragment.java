package com.example.hookahapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class CardFragment extends Fragment {
    public static CardFragment newInstance(){
        return new CardFragment();
    }

    public CardFragment() {}


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.menu_fragment, container, false);
        TextView tmp = v.findViewById(R.id.a);
        tmp.setText("card");
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
