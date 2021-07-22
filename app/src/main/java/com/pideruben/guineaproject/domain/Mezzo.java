package com.pideruben.guineaproject.domain;

public class Mezzo {

    private String targa;
    private int kmPercorsi;

    public Mezzo (String targa, int kmPercorsi){
        this.targa = targa;
        this.kmPercorsi = kmPercorsi;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public int getKmPercorsi() {
        return kmPercorsi;
    }

    public void setKmPercorsi(int kmPercorsi) {
        this.kmPercorsi = kmPercorsi;
    }

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != getClass()) return false;
        Mezzo mezzo = (Mezzo) o;
        return targa.compareTo(mezzo.getTarga()) == 0;
    }
}
