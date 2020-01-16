package com.example.hookahapp.presentation.mainpage.fragments.deal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hookahapp.App;
import com.example.hookahapp.R;
import com.example.hookahapp.data.DealDTO;
import com.example.hookahapp.data.DealDTOParcelable;
import com.example.hookahapp.presentation.deal.DealActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import toothpick.Toothpick;

public class DealFragment extends Fragment {

    @BindView(R.id.deal_recycler)
    RecyclerView recyclerView;

    @Inject
    Context appContext;

    private DealRecyclerAdapter adapter;

    public static DealFragment newInstance(){
        return new DealFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Toothpick.inject(this, Toothpick.openScope(App.class));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new DealRecyclerAdapter((v,position)->{
            Intent intent = new Intent(appContext, DealActivity.class);
            intent.putExtra("deal", new DealDTOParcelable(adapter.getDeal(position)));
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.addItemDecoration(new DealRecyclerItemDecoration(33));
        DealDTO temp = new DealDTO();
        temp.setDealName("aaaaaaaaaaaaaa");
        temp.setDealDescription("Какое-то описание");
        temp.setPicUrl(R.drawable.avatar);
        DealDTO temp1 = new DealDTO();
        temp1.setDealName("иииииииии");
        temp.setDealDescription("Какое-то описание\nКакое-то описание\nКакое-то описание");
        temp1.setPicUrl(R.drawable.avatar);
        adapter.addNewDeal(temp);
        adapter.addNewDeal(temp1);
        adapter.notifyDataSetChanged();

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
