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
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import static com.pideruben.guineaproject.R.id.nAdulti;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerFrom = findViewById(R.id.spFrom);
        Spinner spinnerTo = findViewById(R.id.spTo);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinnerFermate, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerFrom.setAdapter(adapter);
        spinnerFrom.setOnItemSelectedListener(this);

        spinnerTo.setAdapter(adapter);
        spinnerTo.setOnItemSelectedListener(this);



        int distanzaDaCapolinea =1;
        Fermata from = new Fermata(spinnerFrom.getSelectedItem().toString(), distanzaDaCapolinea);
        Fermata to = new Fermata(spinnerTo.getSelectedItem().toString(), distanzaDaCapolinea);

        Tratta tratta = new Tratta(from, to);
        Passeggero passeggero = new Passeggero();
        Biglietto biglietto = new Biglietto(passeggero,tratta);

        TextView numeroAdulti = findViewById(nAdulti);


        final Button addAdult = findViewById(R.id.buttonAddAdult);
        addAdult.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Log.i("MainPage", "Bottone premuto");
                numeroAdulti.setText("ciao");
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}