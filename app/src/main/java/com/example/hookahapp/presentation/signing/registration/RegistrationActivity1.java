package com.example.hookahapp.presentation.signing.registration;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hookahapp.App;
import com.example.hookahapp.R;
import com.example.hookahapp.presentation.signing.RegOrAuthActivity;
import com.mikepenz.materialize.util.KeyboardUtil;

import java.util.regex.Pattern;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import ru.tinkoff.decoro.MaskImpl;
import ru.tinkoff.decoro.slots.PredefinedSlots;
import ru.tinkoff.decoro.watchers.MaskFormatWatcher;
import toothpick.Toothpick;

public class RegistrationActivity1 extends AppCompatActivity {

    @Inject
    Context appContext;

    @BindView(R.id.reg_telephone_edit)
    EditText phoneNumberEdit;

    @BindView(R.id.reg_mail_edit)
    EditText mailEdit;

    @Override
    public void onCreate(Bundle savedInstanceStated) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceStated);
        setContentView(R.layout.activity_registration_1);

        ButterKnife.bind(this);

        KeyboardUtil keyboardUtil = new KeyboardUtil(this, findViewById(R.id.registration_1_layout));
        keyboardUtil.enable();

        Toothpick.inject(this, Toothpick.openScope(App.class));

        MaskFormatWatcher phoneWatcher = new MaskFormatWatcher(
                new MaskImpl(PredefinedSlots.RUS_PHONE_NUMBER, true));
        phoneWatcher.installOn(phoneNumberEdit);

        String phone = getIntent().getStringExtra("phone");
        if(phone != null) phoneNumberEdit.setText(phone);

        String mail = getIntent().getStringExtra("mail");
        if(mail != null) mailEdit.setText(mail);
    }

    @OnClick(R.id.continue_registration_1)
    void continueClicked(){
        if(!Pattern.compile("\\w+@\\D+\\.\\D+")
                .matcher(mailEdit.getText().toString()).find() ||
                !(phoneNumberEdit.getText().length() == 18))
        {
            phoneNumberEdit.setTextColor(getResources().getColor(R.color.red_text));
            mailEdit.setTextColor(getResources().getColor(R.color.red_text));
        }
        else {
            Intent intent = new Intent(appContext, RegistrationActivity2.class);
            intent.putExtra("phone", phoneNumberEdit.getText().toString());
            intent.putExtra("mail", mailEdit.getText().toString());
            startActivity(intent);
        }
    }

    @OnClick(R.id.close_cross_registration)
    void crossClicked(){
        startActivity(new Intent(appContext, RegOrAuthActivity.class));
        finish();
    }

    @OnTextChanged(R.id.reg_mail_edit)
    void mailChanged(){
        if(Pattern.compile("\\w+@\\D+\\.\\D+")
                .matcher(mailEdit.getText().toString()).find())
            mailEdit.setTextColor(getResources().getColor(R.color.textColour));
    }

    @OnTextChanged(R.id.reg_telephone_edit)
    void telephoneChanged(){
        if (phoneNumberEdit.getText().length() == 18)
            phoneNumberEdit.setTextColor(getResources().getColor(R.color.textColour));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(appContext, RegOrAuthActivity.class));
    }
}
