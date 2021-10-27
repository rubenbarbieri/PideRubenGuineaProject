package com.pideruben.guineaproject.application;

import androidx.appcompat.app.AppCompatActivity;

import com.pideruben.guineaproject.R;
import com.pideruben.guineaproject.domain.Biglietto;
import com.pideruben.guineaproject.domain.Fermata;
import com.pideruben.guineaproject.domain.Passeggero;
import com.pideruben.guineaproject.domain.Tratta;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class old_mainAcrt extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.old_activitymain);

        Spinner spinnerFrom = findViewById(R.id.spFrom);
        Spinner spinnerTo = findViewById(R.id.spTo);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinnerFermate, R.layout.color_spinner_ly);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinnerFrom.setAdapter(adapter);
        spinnerFrom.setOnItemSelectedListener(this);

        spinnerTo.setAdapter(adapter);
        spinnerTo.setOnItemSelectedListener(this);



        int distanzaDaCapolinea = 1;
        Fermata from = new Fermata(spinnerFrom.getSelectedItem().toString(), distanzaDaCapolinea);
        Fermata to = new Fermata(spinnerTo.getSelectedItem().toString(), distanzaDaCapolinea);

        Tratta tratta = new Tratta(from, to);
        Passeggero passeggero = new Passeggero();
        Biglietto biglietto = new Biglietto(passeggero,tratta);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}