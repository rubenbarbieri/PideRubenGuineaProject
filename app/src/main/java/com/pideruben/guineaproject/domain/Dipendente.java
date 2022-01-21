package com.pideruben.guineaproject.domain;

import com.pideruben.guineaproject.values.Enums;

import java.util.Date;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Locale;
import java.time.LocalDateTime;


public class Dipendente {

    private int id;   //Avevamo scritto la classe con solo id e tempo di lavoro, ma non ha senso secondo me inserire la data e il tempo di lavoro ad un dipendente.
    private String nome;
    private String cognome;
    private String password;

    public Dipendente(int id, String nome, String cognome, String password) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {return cognome;}

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o){
        //...
        return false;
    }


}
