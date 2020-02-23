package com.example.hookahapp.domain.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CardPercentReq {

    @SerializedName("phone")
    @Expose
    private String phone;


    public CardPercentReq(String phone) {
        this.phone = phone;
    }
}
