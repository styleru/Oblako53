package com.example.hookahapp.presentation.deal;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bumptech.glide.Glide;
import com.example.hookahapp.App;
import com.example.hookahapp.R;
import com.example.hookahapp.data.DealDTO;
import com.example.hookahapp.data.DealDTOParcelable;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import toothpick.Scope;
import toothpick.Toothpick;

public class DealActivity extends MvpAppCompatActivity  implements DealActivityView{

    @Inject
    @InjectPresenter
    DealActivtyPresenter presenter;

    @BindView(R.id.deal_activity_image)
    ImageView picture;

    @BindView(R.id.deal_activity_close_cross)
    View closeCross;

    @BindView(R.id.deal_activity_deal_description)
    TextView description;

    @BindView(R.id.deal_activity_name)
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal);
        Scope appScope = Toothpick.openScope(App.class);
        Toothpick.inject(this, appScope);
        ButterKnife.bind(this);
        DealDTOParcelable parcelable = getIntent().getParcelableExtra("deal");
        assert parcelable != null;
        DealDTO deal = parcelable.getDeal();
        Glide.with(this)
                .load(deal.getPicUrl())
                .fitCenter()
                .into(picture);
        name.setText(deal.getDealName());
        description.setText(deal.getDealDescription());
    }


    @OnClick(R.id.deal_activity_close_cross)
    public void closeCrossClicked() {
        finish();
    }
}
