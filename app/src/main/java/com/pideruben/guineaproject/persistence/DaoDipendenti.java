package com.pideruben.guineaproject.persistence;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoDipendenti {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    public void inserisciDipendente(EntityDipendente dipendente);

    @Delete
    public void eliminaDipendente(EntityDipendente dipendente);

    @Query("SELECT * FROM EntityDipendente ORDER BY id ASC")
    public List<EntityDipendente> getDipendenti();

}
