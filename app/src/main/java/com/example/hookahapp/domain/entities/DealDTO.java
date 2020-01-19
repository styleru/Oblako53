package com.example.hookahapp.domain.entities;

import com.google.gson.annotations.SerializedName;

public class DealDTO {

    @SerializedName("photo")
    private String photo;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("id")
    private int id;

    public DealDTO(String photo, String name, String description) {
        this.description =  description;
        this.name = name;
        this.photo = photo;
    }

    public DealDTO(){}

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
