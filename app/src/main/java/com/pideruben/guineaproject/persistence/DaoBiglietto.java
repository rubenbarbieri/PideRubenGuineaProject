package com.pideruben.guineaproject.persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.pideruben.guineaproject.domain.Biglietto;

import java.util.List;

public interface DaoBiglietto {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void inserisciBiglietto(Biglietto biglietto);

    @Query("SELECT * FROM biglietti ORDER BY data ASC")
    public List<Biglietto> getAllBiglietti();
}
