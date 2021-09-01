package com.pideruben.guineaproject.domain;

import java.util.Date;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Locale;

public class Biglietto {

    private Passeggero passeggero;
    private Tratta tratta;
    private Date data;
    private double costo;

    public Biglietto(Passeggero passeggero, Tratta tratta){
        if(passeggero != null && tratta != null) {
            this.passeggero = passeggero;
            this.tratta = tratta;
        }
        data = new Date();
        costo = tratta.getPrezzoBiglietto();
    }

    public Tratta getTratta() {
        return tratta;
    }

    public Date getData() {
        return data;
    }

    public double getCosto() {
        return costo;
    }

    public Passeggero getPasseggero() {
        return passeggero;
    }

    public void setPasseggero(Passeggero passeggero) {
        this.passeggero = passeggero;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public boolean equals(Object o){
        if(o == null)
            return false;
        if(this == o)
            return true;
        if(o instanceof Biglietto){
            Biglietto biglietto = (Biglietto) o;
            if(biglietto.getPasseggero().equals(passeggero) && biglietto.getTratta().equals(tratta)
                    && biglietto.getData().equals(data))
                return true;
        }
        return false;
    }
}
