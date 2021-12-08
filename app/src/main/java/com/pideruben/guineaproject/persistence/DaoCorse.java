package com.pideruben.guineaproject.persistence;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoCorse {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void inserisciCorsa(EntityCorsa corsa);

    @Delete
    void deleteCorsa(EntityCorsa corsa);

    @Query("SELECT * FROM corse ORDER BY nCorsa ASC")
    List<EntityCorsa> getAllCorsa();

}
