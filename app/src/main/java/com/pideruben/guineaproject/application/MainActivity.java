package com.pideruben.guineaproject.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Dao;
import androidx.room.Room;

import com.pideruben.guineaproject.R;
import com.pideruben.guineaproject.persistence.AppDatabase;
import com.pideruben.guineaproject.persistence.DaoDipendenti;
import com.pideruben.guineaproject.persistence.EntityDipendente;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "db").build();


    }
}