package com.example.hookahapp.presentation.signing.authorisation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.hookahapp.App;
import com.example.hookahapp.R;
import com.example.hookahapp.presentation.mainpage.MainPageActivity;
import com.example.hookahapp.presentation.signing.RegOrAuthActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import toothpick.Toothpick;

public class AuthorisationActivity extends MvpAppCompatActivity implements AuthorisationActivityView{

    @Inject
    Context appContext;

    @Inject
    SharedPreferences sharedPreferences;


    @InjectPresenter
    AuthorisationActivityPresenter presenter;

    @ProvidePresenter
    AuthorisationActivityPresenter providePresenter(){
        return Toothpick.openScope(App.class).getInstance(AuthorisationActivityPresenter.class);
    }

    @BindView(R.id.mail_edit_enter_activity)
    EditText mailEdit;

    @BindView(R.id.password_edit_enter_activity)
    EditText passwordEdit;

    @BindView(R.id.acivity_authorisation_progress_bar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorisation);
        ButterKnife.bind(this);
        Toothpick.inject(this, Toothpick.openScope(App.class));
    }

    @OnClick(R.id.arrow_back_authorisation)
    public void  backPressed(){
        startActivity(new Intent(appContext, RegOrAuthActivity.class));
        finish();
    }

    @OnClick(R.id.authorisation_continue)
    public void continuePressed(){
        if(mailEdit.getText().length() == 0){
            mailEdit.setTextColor(getResources().getColor(R.color.red_text));
            Toast.makeText(appContext, getResources().getString(R.string.enter_mail),
                    Toast.LENGTH_SHORT).show();
        }
        else if (passwordEdit.getText().length() == 0){
            passwordEdit.setTextColor(getResources().getColor(R.color.red_text));
            Toast.makeText(appContext, getResources().getString(R.string.enter_password),
                    Toast.LENGTH_SHORT).show();
        }

        else if (passwordEdit.getText().length() == 0 && passwordEdit.getText().length() == 0){
            mailEdit.setTextColor(getResources().getColor(R.color.red_text));
            passwordEdit.setTextColor(getResources().getColor(R.color.red_text));
            Toast.makeText(appContext, getResources().getString(R.string.enter_all_fields),
                    Toast.LENGTH_SHORT).show();
        }
        else{
            progressBar.setVisibility(View.VISIBLE);
            presenter.regUser(mailEdit.getText().toString(), passwordEdit.getText().toString());
        }
    }

    public void incorrectMailEntered(){
        mailEdit.setTextColor(getResources().getColor(R.color.red_text));
        Toast.makeText(appContext, getString(R.string.incorrect_mail), Toast.LENGTH_SHORT).show();
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
        Toast.makeText(appContext, getResources().getString(R.string.authorisation_error),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(appContext, RegOrAuthActivity.class));
    }
}
