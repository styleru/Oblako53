package com.example.hookahapp.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.hookahapp.domain.repository.ISharedPreferencesRepository;

import javax.inject.Inject;

public class SharedPreferencesRepository implements ISharedPreferencesRepository {

    private SharedPreferences sharedPreferences;
    private Context appContext;

    private final String authed = "authed";
    private final String username = "username";
    private final String password = "password";
    private final String firstrun = "firstrun";

    @Inject
    public SharedPreferencesRepository(SharedPreferences sharedPreferences, Context appContext){
        this.sharedPreferences = sharedPreferences;
        this.appContext = appContext;
    }

    public String getUsername(){
        return sharedPreferences.getString(username, null);
    }

    public String getPassword(){
        return sharedPreferences.getString(password, null);
    }

    public void saveUserInfo(String name, String password){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(this.authed, true);
        editor.putString(this.username, name);
        editor.putString(this.password, password);
        editor.apply();
    }

    public boolean checkFirstRun(){
        return sharedPreferences.getBoolean(firstrun, true);
    }

    public void setNotFirstRun(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(firstrun, false);
        editor.apply();
    }

    public boolean checkAuth(){
        return sharedPreferences.getBoolean(authed, false);
    }

    @Override
    public void exitProfile() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(this.authed, false);
        editor.apply();
    }
}
