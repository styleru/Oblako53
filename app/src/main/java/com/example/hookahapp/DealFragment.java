package com.example.hookahapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arellomobile.mvp.MvpAppCompatFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import toothpick.Scope;
import toothpick.Toothpick;

public class DealFragment extends Fragment {

    private Unbinder unbinder;
    private RecyclerView recyclerView;
    private Context appContext;

//    @Inject
    DealRecyclerAdapter dealRecyclerAdapter;

    public static DealFragment newInstance(Context appContext){
        return new DealFragment(appContext);
    }

//    @Inject
    public DealFragment(Context appContext) {
        this.appContext = appContext;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Scope appScope = Toothpick.openScope("APP");
        Toothpick.inject(this, appScope);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.deal_fragment, container, false);
        recyclerView = view.findViewById(R.id.deal_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(appContext));
        recyclerView.setAdapter(dealRecyclerAdapter);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
