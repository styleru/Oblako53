package com.example.hookahapp.mainpage.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.hookahapp.R;

public class MenuFragment extends Fragment {


    public static MenuFragment newInstance(){
        return new MenuFragment();
    }

    public MenuFragment() {}


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.menu_fragment, container, false);
        TextView tmp = v.findViewById(R.id.a);
        tmp.setText("menu");
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}