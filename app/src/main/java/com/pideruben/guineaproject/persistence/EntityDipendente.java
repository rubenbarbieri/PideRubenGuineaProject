package com.pideruben.guineaproject.persistence;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/*Osservazione: gli attributi possono essere pubblici o privati con getters e setters,
* l'importante è che Room possa accedervi */

/*La tabella avra il nome della classe, con @columninfo posso specificare un nome diverso
* dall'attributo(default) per quella colonna*/

@Entity
public class EntityDipendente {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "nome")
    public String nome;

    public String cognome;

    /*
    * Non sono sicuro che si possa fare un costruttore a piacere, devo ancora studiare come funziona
    * questa parte

    public EntityDipendente(String nome, String cognome){
        if(nome != null && cognome != null){
            this.nome = nome;
            this.cognome = cognome;
        }
    }
    */

}
