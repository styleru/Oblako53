package com.example.hookahapp.registration;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hookahapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.tinkoff.decoro.MaskImpl;
import ru.tinkoff.decoro.slots.PredefinedSlots;
import ru.tinkoff.decoro.watchers.FormatWatcher;
import ru.tinkoff.decoro.watchers.MaskFormatWatcher;

public class AuthorisationActivity extends AppCompatActivity {

    @BindView(R.id.telephone_edit_enter_activity)
    TextView telephoneEdit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorisation);
        ButterKnife.bind(this);
        FormatWatcher formatWatcher = new MaskFormatWatcher(
                MaskImpl.createTerminated(PredefinedSlots.RUS_PHONE_NUMBER)
        );
        formatWatcher.installOn(telephoneEdit);
    }

    @OnClick(R.id.arrow_back_authorisation)
    void  backPressed(){
        setResult(RESULT_CANCELED);
        finish();
    }

    @OnClick(R.id.authorisation_continue)
    void continuePressed(){
        setResult(RESULT_OK);
        finish();
    }

}
