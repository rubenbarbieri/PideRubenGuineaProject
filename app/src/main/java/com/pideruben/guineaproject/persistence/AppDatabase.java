package com.pideruben.guineaproject.persistence;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {EntityDipendente.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DaoDipendenti daoDipendenti();
    public abstract DaoBiglietto daoBiglietto();

    /*pattern Singleton: l'oggetto RoomDatabase è costoso da creare, quindi è bene avere un'unica
    * istanza di AppDatabase ed usare sempre quella. Quando serve si accede all'istanza con
    * getDatabase() */
    //volatile: mantenuta in memoria centrale -> accessibile a tutti i threads
    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context){
        if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "AppDatabase")
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

}
