package com.pideruben.guineaproject.domain;

public class Fermata {

    private String nome;
    private int distanzaCapolinea;

    public Fermata(String nome, int distanzaCapolinea){
        this.nome = nome;
        this.distanzaCapolinea = distanzaCapolinea;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nuovoNome){
        nome = nuovoNome;
    }

    public int getDistanzaCapolinea(){
        return distanzaCapolinea;
    }
    public void setDistanzaCapolinea(int nuovaDistanza){
        distanzaCapolinea = nuovaDistanza;
    }

    @Override
    public boolean equals(Object o){
        if(o == null)
            return false;
        if(o instanceof Fermata){
            Fermata fermata = (Fermata) o;
            if((fermata.nome.compareTo(this.nome) == 0) && fermata.distanzaCapolinea == this.distanzaCapolinea)
                return true;
        }
        return false;
    }
}
