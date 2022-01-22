package com.pideruben.guineaproject.persistence;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.pideruben.guineaproject.domain.Dipendente;

/*Osservazione: gli attributi possono essere pubblici o privati con getters e setters,
* l'importante è che Room possa accedervi */

/*La tabella avra il nome della classe, con @columninfo posso specificare un nome diverso
* dall'attributo(default) per quella colonna*/

@Entity(tableName = "dipendenti")
public class EntityDipendente {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String nome;

    public String cognome;

    public String password;

    public EntityDipendente(String nome, String cognome, String password){
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
    }

    public EntityDipendente(Dipendente d){
        this.nome = d.getNome();
        this.cognome = d.getCognome();
        this.password = d.getPassword();
        this.id = d.getId();
    }


}
