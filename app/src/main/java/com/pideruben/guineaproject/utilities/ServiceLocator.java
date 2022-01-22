package com.pideruben.guineaproject.utilities;

import com.pideruben.guineaproject.api.DipendentiApiService;
import com.pideruben.guineaproject.values.Costanti;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceLocator {

    public static DipendentiApiService getDipendentiApiService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Costanti.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(DipendentiApiService.class);
    }
}
