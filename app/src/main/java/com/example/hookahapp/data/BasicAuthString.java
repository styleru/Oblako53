package com.example.hookahapp.data;

import android.util.Base64;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;


public class BasicAuthString{


    private String key;

    @Inject
    public BasicAuthString(){
        key = "";
    }

    public String getKey(String username, String password) {
        if (key.isEmpty()){
            byte[] data = new byte[0];
            try {
                data = (username + ":" + password)
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
            data = (username + ":" +
                    password)
                    .getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String tmp = "Basic " + Base64.encodeToString(data, Base64.NO_WRAP);
        return "Basic " + Base64.encodeToString(data, Base64.NO_WRAP);
    }
}


