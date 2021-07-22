package com.pideruben.guineaproject.persistence;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {EntityDipendente.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DaoDipendenti daoDipendenti();

    private static AppDatabase db;

    /*pattern Singleton: l'oggetto RoomDatabase è costoso da creare, quindi è bene avere un'unica
    * istanza di AppDatabase ed usare sempre quella. Quando serve si accede all'istanza con
    * getDatabase() NB: non supporta concorrenza*/

    public static AppDatabase getDatabase(Context context){
        if (db == null){
            db = Room.databaseBuilder(context, AppDatabase.class, "db").build();
        }
        return db;
    }

}
