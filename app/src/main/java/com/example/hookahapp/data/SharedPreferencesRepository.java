package com.example.hookahapp.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.hookahapp.R;
import com.example.hookahapp.domain.repository.ISharedPreferencesRepository;

import javax.inject.Inject;

public class SharedPreferencesRepository implements ISharedPreferencesRepository {

    private SharedPreferences sharedPreferences;
    private Context appContext;

    @Inject
    public SharedPreferencesRepository(SharedPreferences sharedPreferences, Context appContext){
        this.sharedPreferences = sharedPreferences;
        this.appContext = appContext;
    }

    public String getUsername(){
        return sharedPreferences.getString(appContext.getResources()
                .getString(R.string.username), null);
    }

    public String getPassword(){
        return sharedPreferences.getString(appContext.getResources()
                .getString(R.string.password), null);
    }

    public void saveUserInfo(String name, String password){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(appContext.getResources().getString(R.string.authed), true);
        editor.putString(appContext.getResources().getString(R.string.username), name);
        editor.putString(appContext.getResources().getString(R.string.password), password);
        editor.apply();
    }

    public boolean checkFirstRun(){
        return sharedPreferences.getBoolean(appContext.getResources()
                .getString(R.string.first_run), true);
    }

    public void setNotFirstRun(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(appContext.getResources().getString(R.string.first_run), false);
        editor.apply();
    }

    public boolean checkAuth(){
        return sharedPreferences.getBoolean(appContext.getResources()
                .getString(R.string.authed), false);
    }
}
