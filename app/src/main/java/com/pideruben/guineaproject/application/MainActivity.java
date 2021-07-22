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

        final Button addButton = findViewById(R.id.buttonAdd);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                AppDatabase db = AppDatabase.getDatabase(getApplicationContext());
                DaoDipendenti daoDipendenti = db.daoDipendenti();
                daoDipendenti.inserisciDipendente(new EntityDipendente("Lorenzo", "Iacopetta"));
                System.out.println("Aggiunto dipendente");
            }
        });

        final Button showButton = findViewById(R.id.buttonShow);
        showButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AppDatabase db = AppDatabase.getDatabase(getApplicationContext());
                DaoDipendenti daoDipendenti = db.daoDipendenti();
                ArrayList<EntityDipendente> dipendenti = (ArrayList<EntityDipendente>) daoDipendenti.getDipendenti();
                for(EntityDipendente e : dipendenti){
                    System.out.println(e);
                }
            }
        });
    }
}