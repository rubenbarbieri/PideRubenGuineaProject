package com.pideruben.guineaproject.persistence;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.pideruben.guineaproject.values.Enums;

import java.util.Date;

@Entity(tableName = "biglietti")
public class EntityBiglietto {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public Enums.tipoPasseggero passeggero;

    public Enums.tipoBagaglio bagaglio;

    public Date data;

    public String tratta;

}
