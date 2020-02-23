package com.example.hookahapp.domain.repository;

import io.reactivex.Single;

public interface ICardRepository {

    Single<String> getCurrentDiscount();
}
