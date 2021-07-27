
/*TODO Studiare come funziona il focus sui widget in modo da poter selezionare il testo gia presente
*  quando ci clicchi sopra e scrivere senza dover cancellare*/


package com.pideruben.guineaproject.application.login;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.pideruben.guineaproject.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button loginButton = findViewById(R.id.buttonLogin);
        loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.i("Login: ", "Bottone premuto");
            }
        });

        final ImageButton helpImageButton = findViewById(R.id.imageButtonHelp);
        helpImageButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.i("Login", "Hai richiesto aiuto");
            }
        });

        final TextView passwordDimenticata = findViewById(R.id.passwordDimenticata);
        passwordDimenticata.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.i("Login", "Hai scordato la password");
            }
        });
    }

}
