package com.pideruben.guineaproject.domain;

import com.pideruben.guineaproject.values.Enums;

public class Bagaglio {

    private Enums.tipoBagaglio tipoBagaglio;

    public Bagaglio(){tipoBagaglio = Enums.tipoBagaglio.Medio;}
    public Bagaglio(Enums.tipoBagaglio bagaglio){
        tipoBagaglio = bagaglio;
    }

    public void setTipoBagaglio(Enums.tipoBagaglio nuovoBagaglio){
        tipoBagaglio = nuovoBagaglio;
    }

    public Enums.tipoBagaglio getTipoBagaglio(){
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
