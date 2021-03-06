package com.example.hookahapp.domain.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

import java.util.ArrayList;
import java.util.List;

@Parcel(Parcel.Serialization.BEAN)
public class UserDTO {

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
    private List<Integer> birth = new ArrayList<>();

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("photo")
    @Expose
    private String photo = "";

    @SerializedName("status")
    @Expose
    private int status = 0;

    public UserDTO(String email, String password){
        this.email = email;
        this.password = password;
    }

    public UserDTO(String email, String phone, String password){
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.birth.add(1);
        this.birth.add(2);
        this.birth.add(3);
    }

    @ParcelConstructor
    public UserDTO(String name, String surname, String phone, String email,
                   List<Integer> birth, String password, String photo,
                   int status){
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.birth = birth;
        this.password = password;
        this.photo = photo;
        this.status = status;
        this.birth.add(1);
        this.birth.add(2);
        this.birth.add(3);
    }

    public UserDTO(){}

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

    public List<Integer> getBirth() {
        return birth;
    }

    public void setBirth(List<Integer> birth) {
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
