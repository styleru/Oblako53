package com.example.hookahapp.domain.repository;

import com.example.hookahapp.domain.entities.DealDTO;

import java.util.List;

import io.reactivex.Single;

public interface IDealRepository {
    Single<List<DealDTO>> getAllDeals();
    Single<DealDTO> getDealById(int id);
}
