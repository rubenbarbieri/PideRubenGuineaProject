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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerFrom = findViewById(R.id.spinner1);
        Spinner spinnerTo = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinnerFermate, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinnerFrom.setAdapter(adapter);
        spinnerFrom.setOnItemSelectedListener(this);

        spinnerTo.setAdapter(adapter);
        spinnerTo.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}