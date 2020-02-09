package com.example.hookahapp.domain.repository;

public interface IBasicAuthStringRepository {

    String getKey(String username, String password);
    String createKeyFromString(String username, String password);
}
