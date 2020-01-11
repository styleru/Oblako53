package com.example.hookahapp.registration;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hookahapp.R;
import com.mikepenz.materialize.util.KeyboardUtil;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.tinkoff.decoro.MaskImpl;
import ru.tinkoff.decoro.slots.PredefinedSlots;
import ru.tinkoff.decoro.watchers.MaskFormatWatcher;

public class RegistrationActivity1 extends AppCompatActivity {

    @Inject
    Context appContext;

    @BindView(R.id.reg_telephone_edit)
    EditText phoneNumberEdit;

    @Override
    public void onCreate(Bundle savedInstanceStated) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceStated);
        setContentView(R.layout.activity_registration_1);
        ButterKnife.bind(this);
        KeyboardUtil keyboardUtil = new KeyboardUtil(this, findViewById(R.id.registration_1_layout));
        keyboardUtil.enable();
        MaskFormatWatcher phoneWatcher = new MaskFormatWatcher(
                new MaskImpl(PredefinedSlots.RUS_PHONE_NUMBER, true));
        phoneWatcher.installOn(phoneNumberEdit);
    }

    @OnClick(R.id.continue_registration_1)
    void continueClicked(){
        startActivityForResult(new Intent(appContext, RegistrationActivity2.class), 1);
    }

    @OnClick(R.id.close_cross_registration)
    void crossClicked(){
        setResult(RESULT_CANCELED);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null){

            data.putExtra("phone", phoneNumberEdit.getText());
            setResult(RESULT_OK, data);
            finish();
        }
    }
}
