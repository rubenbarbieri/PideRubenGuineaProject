package com.pideruben.guineaproject.domain;

import com.pideruben.guineaproject.values.Enums;

import java.util.Date;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Locale;
import java.time.LocalDateTime;


public class Dipendente {

    private int id;   //Avevamo scritto la classe con solo id e tempo di lavoro, ma non ha senso secondo me inserire la data e il tempo di lavoro ad un dipendente.
    private Enums.tipoDipendente tipoDipendente;
    private String username;
    private String password;

    public Dipendente(int id, Enums.tipoDipendente tipoDipendente, String username, String password) {
        this.id = id;
        this.tipoDipendente = tipoDipendente;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public Enums.tipoDipendente getTipoDipendente() {
        return tipoDipendente;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}
