package com.example.hookahapp.data;

import com.example.hookahapp.domain.repository.ICardRepository;

import javax.inject.Inject;

public class CardRepository implements ICardRepository {

    @Inject
    CardRepository(){

    }

    @Override
    public int getCurrentDiscount() {
        return 3;
    }
}
