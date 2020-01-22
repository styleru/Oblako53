package com.example.hookahapp.data;

import android.content.SharedPreferences;
import android.util.Base64;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;


public class BasicAuthString {

    @Inject
    SharedPreferences sharedPreferences;

    private String key;

    @Inject
    public BasicAuthString(){
        byte[] data = new byte[0];
        try {
            data = (sharedPreferences.getString("username", "") + ":" +
                    sharedPreferences.getString("password", ""))
                    .getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.key = "Basic " + Base64.encodeToString(data, Base64.NO_WRAP);
    }

    public String getKey() {
        return key;
    }
}


