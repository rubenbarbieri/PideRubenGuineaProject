package com.pideruben.guineaproject.domain;


import com.google.gson.annotations.SerializedName;

public class Dipendente {

    @SerializedName("id")
    private int id;
    @SerializedName("nome")
    private String nome;
    @SerializedName("cognome")
    private String cognome;
    @SerializedName("password")
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
