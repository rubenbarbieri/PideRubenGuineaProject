package com.pideruben.guineaproject.persistence;

import androidx.lifecycle.LiveData;
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

    /*Con LiveData posso eseguire operazioni quando i dati vengono aggiornati
    * è una specie di observer per il database??*/
    @Query("SELECT * FROM EntityDipendente ORDER BY id ASC")
    public LiveData<List<EntityDipendente>> getDipendenti();

}
