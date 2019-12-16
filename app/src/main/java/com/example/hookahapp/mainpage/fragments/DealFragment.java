package com.example.hookahapp.mainpage.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hookahapp.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import data.DealDTO;
import toothpick.Toothpick;

public class DealFragment extends Fragment {

    @BindView(R.id.deal_recycler)
    RecyclerView recyclerView;

    @Inject
    DealRecyclerAdapter dealRecyclerAdapter;

    public static DealFragment newInstance(){
        return new DealFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Toothpick.inject(this, Toothpick.openScope("App"));
}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView.setAdapter(dealRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.addItemDecoration(new DealRecyclerItemDecoration(33));
        DealDTO temp = new DealDTO();
        temp.setDealName("aaaaaaaaaaaaaa");
        temp.setPicUrl(R.drawable.avatar);
        DealDTO temp1 = new DealDTO();
        temp1.setDealName("иииииииии");
        temp1.setPicUrl(R.drawable.avatar);
        dealRecyclerAdapter.addNewDeal(temp);
        dealRecyclerAdapter.addNewDeal(temp1);
        dealRecyclerAdapter.notifyDataSetChanged();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.deal_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
