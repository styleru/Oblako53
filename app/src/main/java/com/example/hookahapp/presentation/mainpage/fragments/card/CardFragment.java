package com.example.hookahapp.presentation.mainpage.fragments.card;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hookahapp.R;

public class CardFragment extends Fragment {
    public static CardFragment newInstance(){
        return new CardFragment();
    }

    public CardFragment() {}


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        return inflater.inflate(R.layout.card_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
      //  TextView tmp = view.findViewById(R.id.a);
      //  tmp.setText("card");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
