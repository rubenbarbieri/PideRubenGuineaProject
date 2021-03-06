package com.pideruben.guineaproject.persistence;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoDipendenti {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void inserisciDipendente(EntityDipendente dipendente);

    @Delete
    public void eliminaDipendente(EntityDipendente dipendente);

    @Query("SELECT * FROM dipendenti ORDER BY id ASC")
    public List<EntityDipendente> getDipendenti();

}
