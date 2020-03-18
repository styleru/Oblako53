package com.example.hookahapp.presentation.mainpage.fragments.deal;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.hookahapp.App;
import com.example.hookahapp.R;
import com.example.hookahapp.domain.entities.DealDTO;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import toothpick.Toothpick;

public class DealFragment extends MvpAppCompatFragment implements DealFragmentView {

    @BindView(R.id.deal_recycler)
    RecyclerView recyclerView;

    @BindView(R.id.deal_fragment_progressbar)
    ProgressBar progressBar;

    @BindView(R.id.empty_text)
    TextView emptyText;

    @Inject
    Context appContext;

    @InjectPresenter
    DealFragmentPresenter presenter;

    @ProvidePresenter
    DealFragmentPresenter providePresenter(){
        return Toothpick.openScope(App.class).getInstance(DealFragmentPresenter.class);
    }

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

        adapter = new DealRecyclerAdapter();

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.addItemDecoration(new DealRecyclerItemDecoration(33));
        progressBar.setVisibility(View.VISIBLE);
        presenter.getDeals();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.deal_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public void replaceItems(List<DealDTO> deals){
        adapter.setItems(deals);
        adapter.notifyDataSetChanged();

        emptyText.setVisibility(deals.isEmpty() ? View.VISIBLE : View.GONE);
    }

    @Override
    public void setProgress(boolean visible) {
        progressBar.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showToast(int text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }
}
