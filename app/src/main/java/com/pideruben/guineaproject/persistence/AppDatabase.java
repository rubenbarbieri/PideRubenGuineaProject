package com.pideruben.guineaproject.persistence;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {EntityDipendente.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DaoDipendenti daoDipendenti();
}
