package com.pideruben.guineaproject.domain;

import com.pideruben.guineaproject.values.Costanti;
import com.pideruben.guineaproject.values.Costanti.tipoPasseggero;

public class Passeggero {

    private tipoPasseggero tipoPasseggero;

    public Passeggero(){
        tipoPasseggero = Costanti.tipoPasseggero.Adulto;
    }
    public Passeggero(Costanti.tipoPasseggero tipo){
        tipoPasseggero = tipo;
    }

    public Costanti.tipoPasseggero getTipoPasseggero() {
        return tipoPasseggero;
    }

    public void setTipoPasseggero(tipoPasseggero tipo){
        tipoPasseggero = tipo;
    }

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Passeggero passeggero = (Passeggero) o;
        return passeggero.getTipoPasseggero() == tipoPasseggero;
    }
}
