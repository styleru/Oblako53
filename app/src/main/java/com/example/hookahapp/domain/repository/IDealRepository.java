package com.example.hookahapp.domain.repository;

import com.example.hookahapp.domain.entities.DealDTO;

import java.util.List;

import io.reactivex.Single;

public interface IDealRepository {
    Single<List<DealDTO>> getAllDeals(String key);
    Single<DealDTO> getDealById(int id, String key);
}
