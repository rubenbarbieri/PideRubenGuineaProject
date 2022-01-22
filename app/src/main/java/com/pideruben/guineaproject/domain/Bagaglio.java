package com.pideruben.guineaproject.domain;

import com.pideruben.guineaproject.values.Costanti;

public class Bagaglio {

    private Costanti.tipoBagaglio tipoBagaglio;

    public Bagaglio(){tipoBagaglio = Costanti.tipoBagaglio.Medio;}
    public Bagaglio(Costanti.tipoBagaglio bagaglio){
        tipoBagaglio = bagaglio;
    }

    public void setTipoBagaglio(Costanti.tipoBagaglio nuovoBagaglio){
        tipoBagaglio = nuovoBagaglio;
    }

    public Costanti.tipoBagaglio getTipoBagaglio(){
        return tipoBagaglio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bagaglio bagaglio = (Bagaglio) o;
        return getTipoBagaglio() == bagaglio.getTipoBagaglio();
    }

}
