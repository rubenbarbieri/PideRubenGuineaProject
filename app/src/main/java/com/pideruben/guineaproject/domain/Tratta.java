package com.pideruben.guineaproject.domain;

import static java.lang.Math.abs;

public class Tratta {
    private int lunghezza;
    private Fermata inizio;
    private Fermata fine;

    public Tratta(Fermata inizio, Fermata fine){
        if(inizio != null && fine != null) {
            this.inizio = inizio;
            this.fine = fine;
            this.lunghezza = abs(inizio.getDistanzaCapolinea() - fine.getDistanzaCapolinea());
        }
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
        if (o == null) return false;
        if (o == this) return true;
        if (o instanceof Tratta){
            Tratta tratta = (Tratta)o;
            if(tratta.getInizio().equals(this.getInizio()) && tratta.getFine().equals(this.getFine()))
                return true;
        }
        return false;
    }

    public double getPrezzoBiglietto(){
        /*Supponendo di calcolare il prezzo solo in base alla lunghezza del tragitto*/
        double c = 0.1; //moltiplicatore costo per km
        return c * lunghezza;
    }

}
