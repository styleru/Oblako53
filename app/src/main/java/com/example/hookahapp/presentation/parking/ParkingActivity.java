package com.example.hookahapp.presentation.parking;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.hookahapp.App;
import com.example.hookahapp.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.tinkoff.decoro.MaskImpl;
import ru.tinkoff.decoro.slots.PredefinedSlots;
import ru.tinkoff.decoro.watchers.MaskFormatWatcher;
import toothpick.Scope;
import toothpick.Toothpick;


public class ParkingActivity extends MvpAppCompatActivity implements ParkingActivityView{

    @Inject
    @InjectPresenter
    ParkingActivityPresenter presenter;

    @BindView(R.id.success_parking)
    TextView successParking;

    @BindView(R.id.parking_screen_cur_edit)
    TextView curNumberEdit;

    @BindView(R.id.parking_screen_phone_edit)
    TextView phoneNumberEdit;

    @BindView(R.id.parking_screen_name_edit)
    TextView nameEdit;

    @Inject
    Context appContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);
        ButterKnife.bind(this);
        successParking.setVisibility(View.GONE);

        Scope appScope = Toothpick.openScope(App.class);
        Toothpick.inject(this, appScope);

        MaskFormatWatcher phoneWatcher = new MaskFormatWatcher(
                new MaskImpl(PredefinedSlots.RUS_PHONE_NUMBER, true));
        phoneWatcher.installOn(phoneNumberEdit);
    }

    @OnClick(R.id.parking_order_button)
    public void orderButtonPressed(){
        if (nameEdit.getText().toString().isEmpty() || curNumberEdit.getText().toString().isEmpty()
                || phoneNumberEdit.getText().toString().isEmpty()
                || !(phoneNumberEdit.getText().length() == 18)){
            Toast.makeText(appContext, "Введите все данные", Toast.LENGTH_SHORT).show();
        }

        else presenter.checkStrings(curNumberEdit.getText().toString(), nameEdit.getText().toString());
    }



    @OnClick(R.id.parking_activity_close)
    public void closeCrossClicked(){
        finish();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(appContext, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void successParking() {
        successParking.setVisibility(View.VISIBLE);
    }
}
