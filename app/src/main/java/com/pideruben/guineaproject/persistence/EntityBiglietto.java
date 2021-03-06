package com.pideruben.guineaproject.persistence;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "biglietti")
public class EntityBiglietto {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public int n_adulti;
    public int n_bambini;
    public int n_studenti;
    public int n_invalidi;

    public int n_bagagli_piccoli;
    public int n_bagagli_medi;
    public int n_bagagli_grandi;

    public String data;
    public String tratta;
    public String targa;
    public int n_corsa;
    public String da;
    public String a;

    public int prezzo;



    public EntityBiglietto(int n_adulti, int n_bambini, int n_studenti, int n_invalidi,
                           int n_bagagli_piccoli, int n_bagagli_medi, int n_bagagli_grandi,
                           String data, String tratta, String targa, int n_corsa, int prezzo, String da, String a){
        this.n_adulti = n_adulti;
        this.n_bambini = n_bambini;
        this.n_studenti = n_studenti;
        this.n_invalidi = n_invalidi;
        this.n_bagagli_piccoli = n_bagagli_piccoli;
        this.n_bagagli_medi = n_bagagli_medi;
        this.n_bagagli_grandi = n_bagagli_grandi;
        this.data = data;
        this.tratta = tratta;
        this.targa = targa;
        this.da = da;
        this.a = a;
        this.n_corsa = n_corsa;
        this.prezzo = prezzo;

    }

    public String toString() {
        return "Adulti: " + n_adulti +
                ", Bambini: " + n_bambini +
                ", Studenti: " + n_studenti +
                ", Invalidi :" + n_invalidi +
                ", Bagagli piccoli: " + n_bagagli_piccoli +
                ", Bagagli medi: " + n_bagagli_medi +
                ", Bagagli grandi: " + n_bagagli_grandi +
                ", Data: " + data.toString() +
                ", Tratta: " + tratta +
                ", Targa: " + targa +
                ", da: " + da +
                ", a: " + a +
                ", Corsa: " + n_corsa +
                ", Prezzo: " + prezzo;
    }

}
