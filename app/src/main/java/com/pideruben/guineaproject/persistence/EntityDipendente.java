package com.pideruben.guineaproject.persistence;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

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

}
