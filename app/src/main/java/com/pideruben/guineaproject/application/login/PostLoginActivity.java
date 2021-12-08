package com.pideruben.guineaproject.application.login;

import androidx.appcompat.app.AppCompatActivity;
import com.pideruben.guineaproject.R;
import com.pideruben.guineaproject.application.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class PostLoginActivity extends AppCompatActivity {

    private Spinner spinnerTarghe;
    private Button buttonConfermaTarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_login);

        spinnerTarghe = findViewById(R.id.spTarghe);
        ArrayList<String> targhe = new ArrayList<String>();
        targhe.add("Ruben");
        targhe.add("Pide");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.color_spinner_ly,targhe);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTarghe.setAdapter(adapter);

        buttonConfermaTarga = findViewById(R.id.buttonConfermaTarga);
        buttonConfermaTarga.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent myIntent = new Intent(v.getContext(), MainActivity.class);
                startActivity(myIntent);
                finish();
            }
        });

    }
}