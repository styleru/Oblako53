package com.example.hookahapp.presentation.signing.registration;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.hookahapp.App;
import com.example.hookahapp.R;
import com.example.hookahapp.presentation.mainpage.MainPageActivity;
import com.mikepenz.materialize.util.KeyboardUtil;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import toothpick.Toothpick;

public class RegistrationActivity2 extends MvpAppCompatActivity implements RegistrationActivity2View {

    @Inject
    Context appContext;

    @Inject
    SharedPreferences sharedPreferences;

    @BindView(R.id.reg_password_edit)
    EditText passwordEdit;

    @BindView(R.id.acivity_registration_progress_bar)
    ProgressBar progressBar;


    @InjectPresenter
    RegistrationActivity2Presenter presenter;

    @ProvidePresenter
    RegistrationActivity2Presenter providePresenter(){
        return Toothpick.openScope(App.class).getInstance(RegistrationActivity2Presenter.class);
    }

    @Override
    public void onCreate(Bundle savedInstanceStated) {
        setTheme(R.style.AppTheme);
        Toothpick.inject(this, Toothpick.openScope(App.class));
        super.onCreate(savedInstanceStated);
        setContentView(R.layout.activity_registration_2);
        ButterKnife.bind(this);
        KeyboardUtil keyboardUtil = new KeyboardUtil(this, findViewById(R.id.registration_layout_2));
        keyboardUtil.enable();
    }

    @OnClick(R.id.continue_registration_2)
    public void continueClicked(){
        if (passwordEdit.getText().length() >= 6){
            progressBar.setVisibility(View.VISIBLE);
            presenter.registerUser(getIntent().getStringExtra("mail"),
                    getIntent().getStringExtra("phone"),
                    passwordEdit.getText().toString());
        }
        else {
            passwordEdit.setTextColor(getResources().getColor(R.color.red_text));
            Toast.makeText(appContext, "Пароль слишком короткий", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(appContext, RegistrationActivity1.class);
        intent.putExtra("phone", getIntent().getStringExtra("phone"));
        intent.putExtra("mail", getIntent().getStringExtra("mail"));
        startActivity(intent);
        finish();
    }

    @Override
    public void startMainActivity() {
        progressBar.setVisibility(View.INVISIBLE);
        startActivity(new Intent(appContext, MainPageActivity.class));
        finish();
    }

    @Override
    public void authorisationError() {
        progressBar.setVisibility(View.INVISIBLE);
        Toast.makeText(appContext, "Ошибка регистрации\nПовторите попытку позднее",
                Toast.LENGTH_SHORT).show();
    }

    @OnTextChanged(R.id.reg_password_edit)
    void passwordChanged(){
        if (passwordEdit.getText().length() >= 6)
            passwordEdit.setTextColor(getResources().getColor(R.color.textColour));
    }
}