package com.example.hookahapp.presentation.mainpage.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.hookahapp.App;
import com.example.hookahapp.R;
import com.example.hookahapp.presentation.parking.ParkingActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import toothpick.Toothpick;

public class ParkingFragment extends Fragment {

    public static ParkingFragment newInstance(){
        return new ParkingFragment();
    }

    public ParkingFragment() {}

    @BindView(R.id.parking_item_image)
    ImageView image;

    @Inject
    Context appContext;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Toothpick.inject(this, Toothpick.openScope(App.class));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.parking_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        Glide.with(view)
                .load(R.drawable.parking_picture)
                .into(image);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick(R.id.parking_fragment_order_button)
    void orderButtonClicked(){
        startActivity(new Intent(appContext, ParkingActivity.class));
    }

}
