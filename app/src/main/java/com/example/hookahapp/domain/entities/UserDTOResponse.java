package com.example.hookahapp.domain.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel(Parcel.Serialization.BEAN)
public class UserDTOResponse {

    @SerializedName("name")
    @Expose
    private String name = "";

    @SerializedName("surname")
    @Expose
    private String surname = "";

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("birth")
    @Expose
    private String birth;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("photo")
    @Expose
    private String photo = "";

    @SerializedName("status")
    @Expose
    private int status = 0;

    public UserDTOResponse(String email, String password){
        this.email = email;
        this.password = password;
    }

    public UserDTOResponse(String email, String phone, String password){
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    @ParcelConstructor
    public UserDTOResponse(String name, String surname, String phone, String email,
                           String birth, String password, String photo,
                           int status){
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.birth = birth;
        this.password = password;
        this.photo = photo;
        this.status = status;
    }

    public UserDTOResponse(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
