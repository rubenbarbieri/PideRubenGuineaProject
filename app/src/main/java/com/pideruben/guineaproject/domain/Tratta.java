package com.pideruben.guineaproject.domain;

import static java.lang.Math.abs;

public class Tratta {
    private int lunghezza;
    private Fermata inizio;
    private Fermata fine;

    public Tratta(Fermata inizio, Fermata fine){
        this.inizio = inizio;
        this.fine = fine;
        int lunghezza = abs(inizio.getDistanzaCapolinea() - fine.getDistanzaCapolinea());
        this.lunghezza = lunghezza;
    }

    public int getLunghezza(){
        return lunghezza;
    }

    public Fermata getInizio() {
        return inizio;
    }

    public Fermata getFine(){
        return fine;
    }

    @Override
    public boolean equals(Object o){
        if (o == null)
            return false;
        if (o instanceof Tratta){
            Tratta tratta = (Tratta)o;
            if(tratta.getInizio().equals(this.getInizio()) && tratta.getFine().equals(this.getFine()))
                return true;
        }
        return false;
    }

}
