package com.example.hookahapp.presentation.registration;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hookahapp.App;
import com.example.hookahapp.R;
import com.example.hookahapp.presentation.mainpage.MainPageActivity;

import java.util.regex.Pattern;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import toothpick.Toothpick;

public class AuthorisationActivity extends AppCompatActivity {

    @Inject
    Context appContext;

    @Inject
    SharedPreferences sharedPreferences;

    @BindView(R.id.mail_edit_enter_activity)
    EditText mailEdit;

    @BindView(R.id.password_edit_enter_activity)
    EditText passwordEdit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorisation);
        ButterKnife.bind(this);
        Toothpick.inject(this, Toothpick.openScope(App.class));
    }

    @OnClick(R.id.arrow_back_authorisation)
    void  backPressed(){
        setResult(RESULT_CANCELED);
        finish();
    }

    @OnClick(R.id.authorisation_continue)
    void continuePressed(){
        if(!Pattern.compile("\\w+@\\D+\\.\\D+")
                .matcher(mailEdit.getText().toString()).find() || passwordEdit.getText().length() < 6){
            mailEdit.setTextColor(getResources().getColor(R.color.red_text));
        }
        // TODO проверка авторизации
        else{
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("authed", true);
            editor.apply();
            startActivity(new Intent(appContext, MainPageActivity.class));
            finish();
        }
    }

}
