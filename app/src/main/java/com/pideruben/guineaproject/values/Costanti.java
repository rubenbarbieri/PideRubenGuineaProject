package com.pideruben.guineaproject.values;

public class Costanti {

    public enum tipoPasseggero {
        Adulto,
        Bambino,
        Invalido,
        Studente
    };

    public enum tipoBagaglio {
        Piccolo,
        Medio,
        Grande
    };

    public enum tipoDipendente {
        Autista,
        Controllore
    };

    public static final String BASE_URL = "http://172.105.70.55";
    public static final String GET_DIPENDENTI = "/api/get/dipendenti";
    public static final String POST_BIGLIETTI = "/api/corse";

}
