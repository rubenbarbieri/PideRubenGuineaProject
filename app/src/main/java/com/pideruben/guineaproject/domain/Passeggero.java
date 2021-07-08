package com.pideruben.guineaproject.domain;

import com.pideruben.guineaproject.values.Enums;
import com.pideruben.guineaproject.values.Enums.tipoPasseggero;

public class Passeggero {

    private tipoPasseggero tipoPasseggero;

    public Passeggero(){
        tipoPasseggero = Enums.tipoPasseggero.Adulto;
    }
    public Passeggero(String tipo){
        /*Rivedere enum e finire*/
    }

    public Enums.tipoPasseggero getTipoPasseggero() {
        return tipoPasseggero;
    }

    public void setTipoPasseggero(tipoPasseggero tipo){
        tipoPasseggero = tipo;
    }
}
