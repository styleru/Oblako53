package com.example.hookahapp.data;

import com.example.hookahapp.data.api.CardAPI;
import com.example.hookahapp.domain.entities.CardPercentReq;
import com.example.hookahapp.domain.repository.ICardRepository;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Retrofit;

public class CardRepository implements ICardRepository {

    private CardAPI cardAPI;
    private SharedPreferencesRepository preferencesRepository;
    private BasicAuthString basicAuthString;
    private AuthRepository authRepository;

    @Inject
    CardRepository(Retrofit retrofit, SharedPreferencesRepository preferencesRepository, BasicAuthString basicAuthString, AuthRepository authRepository){
        this.cardAPI = retrofit.create(CardAPI.class);
        this.preferencesRepository = preferencesRepository;
        this.basicAuthString = basicAuthString;
        this.authRepository = authRepository;
    }

    @Override
    public Single<String> getCurrentDiscount() {
        return authRepository.getUserData().flatMap(userDTOResponse ->
                cardAPI.getCardDiscount(new CardPercentReq(userDTOResponse.getPhone()
                        .replace(" ", "")
                        .replace("(", "")
                        .replace(")", "")
                        .replace("-", ""))));
    }
}
