package com.pideruben.guineaproject.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.pideruben.guineaproject.R;
import com.pideruben.guineaproject.domain.Dipendente;
import com.pideruben.guineaproject.persistence.AppDatabase;
import com.pideruben.guineaproject.persistence.DaoDipendenti;
import com.pideruben.guineaproject.persistence.EntityDipendente;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}