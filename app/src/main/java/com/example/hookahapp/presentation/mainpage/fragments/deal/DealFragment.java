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
import com.example.hookahapp.domain.entities.DealDTO;
import com.example.hookahapp.presentation.deal.DealActivity;

import org.parceler.Parcels;

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
            intent.putExtra("deal", Parcels.wrap(adapter.getDeal(position)));
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.addItemDecoration(new DealRecyclerItemDecoration(33));
        DealDTO temp = new DealDTO();
        temp.setName("aaaaaaaaaaaaaa");
        temp.setDescription("Какое-то описание");
        temp.setPhoto("https://i.ytimg.com/vi/_tK84M_w4Bw/maxresdefault.jpg");
        DealDTO temp1 = new DealDTO();
        temp1.setName("иииииииии");
        temp.setDescription("Какое-то описание\nКакое-то описание\nКакое-то описание");
        temp1.setPhoto("https://i.ytimg.com/vi/_tK84M_w4Bw/maxresdefault.jpg");
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
