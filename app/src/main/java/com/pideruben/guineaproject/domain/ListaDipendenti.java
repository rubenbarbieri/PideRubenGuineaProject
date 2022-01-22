package com.pideruben.guineaproject.domain;

import com.google.gson.annotations.SerializedName;
import com.pideruben.guineaproject.persistence.EntityDipendente;

import java.util.ArrayList;
import java.util.List;

public class ListaDipendenti {

    @SerializedName("list")
    private List<Dipendente> dipendenti;

    public List<Dipendente> getDipendenti() {
        return dipendenti;
    }

    public void setDipendenti(List<Dipendente> dipendenti) {
        this.dipendenti = dipendenti;
    }
}
