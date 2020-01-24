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
        key = "";
    }

    public String getKey() {
        if (key.isEmpty()){
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
        return key;
    }

    public String createKeyFromString(String username, String password){
        byte[] data = new byte[0];
        try {
            data = (sharedPreferences.getString("username", "") + ":" +
                    sharedPreferences.getString("password", ""))
                    .getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "Basic " + Base64.encodeToString(data, Base64.NO_WRAP);
    }
}


