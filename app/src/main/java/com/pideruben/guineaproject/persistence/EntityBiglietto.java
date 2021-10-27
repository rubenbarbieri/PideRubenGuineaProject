package com.pideruben.guineaproject.persistence;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.pideruben.guineaproject.values.Enums;

import java.util.Date;

@Entity(tableName = "biglietti")
public class EntityBiglietto {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private Enums.tipoPasseggero passeggero;

    @ColumnInfo
    private Enums.tipoBagaglio bagaglio;

    @ColumnInfo
    private Date data;

    @ColumnInfo
    private String tratta;

    //ID sempre uguale a 0 (autogenerate)
    public EntityBiglietto(int id, Enums.tipoPasseggero passeggero, Enums.tipoBagaglio bagaglio,
                           Date data, String tratta) {
        if(id == 0) {
            this.id = id;
            this.passeggero = passeggero;
            this.bagaglio = bagaglio;
            this.data = data;
            this.tratta = tratta;
        }
    }
}
