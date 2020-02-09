package com.example.hookahapp.domain.repository;

public interface ISharedPreferencesRepository {

    String getUsername();
    String getPassword();
    void saveUserInfo(String name, String password);
    boolean checkFirstRun();
    void setNotFirstRun();
    boolean checkAuth();
}
