package com.pideruben.guineaproject.persistence;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoBiglietto {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void inserisciBiglietto(EntityBiglietto biglietto);

    @Delete
    void deleteBiglietto(EntityBiglietto biglietto);

    @Query("SELECT * FROM biglietti ORDER BY data ASC")
    List<EntityBiglietto> getAllBiglietti();
}
