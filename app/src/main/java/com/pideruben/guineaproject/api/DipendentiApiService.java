package com.pideruben.guineaproject.api;

import com.pideruben.guineaproject.domain.ListaDipendenti;
import com.pideruben.guineaproject.values.Costanti;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DipendentiApiService {

    @GET(Costanti.GET_DIPENDENTI)
    public Call<ListaDipendenti> getDipendenti();

}
