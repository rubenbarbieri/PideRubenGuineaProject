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

    @Query("SELECT n_adulti FROM biglietti WHERE n_corsa= :nCorsa AND data= :Data")
    List<Integer> getAdultiCorsaData(int nCorsa, String Data);

    @Query("SELECT n_bambini FROM biglietti WHERE n_corsa= :nCorsa AND data= :Data")
    List<Integer> getBambiniCorsaData(int nCorsa, String Data);

    @Query("SELECT n_studenti FROM biglietti WHERE n_corsa= :nCorsa AND data= :Data")
    List<Integer> getStudentiCorsaData(int nCorsa, String Data);

    @Query("SELECT n_invalidi FROM biglietti WHERE n_corsa= :nCorsa AND data= :Data")
    List<Integer> getInvalidiCorsaData(int nCorsa, String Data);

    @Query("SELECT n_bagagli_grandi FROM biglietti WHERE n_corsa= :nCorsa AND data= :Data")
    List<Integer> getBigLuggageCorsaData(int nCorsa, String Data);

    @Query("SELECT n_bagagli_medi FROM biglietti WHERE n_corsa= :nCorsa AND data= :Data")
    List<Integer> getMediumLuggageCorsaData(int nCorsa, String Data);

    @Query("SELECT n_bagagli_piccoli FROM biglietti WHERE n_corsa= :nCorsa AND data= :Data")
    List<Integer> getSmallLugageCorsaData(int nCorsa, String Data);

}
