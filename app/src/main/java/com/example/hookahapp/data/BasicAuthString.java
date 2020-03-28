package com.example.hookahapp.data;

import android.util.Base64;

import java.nio.charset.StandardCharsets;

import javax.inject.Inject;


public class BasicAuthString{

    @Inject
    public BasicAuthString(){}

    public String getKey(String username, String password) {
        byte[] data;
        data = (username + ":" + password)
                .getBytes(StandardCharsets.UTF_8);
        return  "Basic " + Base64.encodeToString(data, Base64.NO_WRAP);
    }
}
