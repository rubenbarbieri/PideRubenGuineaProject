package com.pideruben.guineaproject.persistence;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository {

    private DaoDipendenti mDaoDipendenti;
    private LiveData<List<EntityDipendente>> mDipendenti;

    public Repository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        mDaoDipendenti = db.daoDipendenti();
        mDipendenti = mDaoDipendenti.getDipendenti();
    }

    LiveData<List<EntityDipendente>> getDipendenti(){
        return mDipendenti;
    }

    void insert(EntityDipendente dipendente) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            mDaoDipendenti.inserisciDipendente(dipendente);
        });
    }

}
