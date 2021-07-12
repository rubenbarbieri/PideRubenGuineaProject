package com.pideruben.guineaproject.domain;

import com.pideruben.guineaproject.values.Enums;
import com.pideruben.guineaproject.values.Enums.tipoPasseggero;

public class Passeggero {

    private tipoPasseggero tipoPasseggero;

    public Passeggero(){
        tipoPasseggero = Enums.tipoPasseggero.Adulto;
    }
    public Passeggero(Enums.tipoPasseggero tipo){
        tipoPasseggero = tipo;
    }

    public Enums.tipoPasseggero getTipoPasseggero() {
        return tipoPasseggero;
    }

    public void setTipoPasseggero(tipoPasseggero tipo){
        tipoPasseggero = tipo;
    }

    @Override
    public boolean equals(Object o){
        if(o == null)
            return false;
        if(o == this)
            return true;
        if(o instanceof Passeggero){
            Passeggero passeggero = (Passeggero) o;
            if(passeggero.getTipoPasseggero() == this.tipoPasseggero)
                return true;
        }
        return false;
    }
}
