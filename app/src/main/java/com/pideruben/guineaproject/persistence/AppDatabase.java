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

    /*pattern Singleton: l'oggetto RoomDatabase è costoso da creare, quindi è bene avere un'unica
    * istanza di AppDatabase ed usare sempre quella. Quando serve si accede all'istanza con
    * getDatabase() */
    //volatile: mantenuta in memoria centrale -> accessibile a tutti i threads
    private static volatile AppDatabase INSTANCE;

    private final static int NUMBER_OF_THREADS = 2;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static AppDatabase getDatabase(Context context){
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "AppDatabase")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
