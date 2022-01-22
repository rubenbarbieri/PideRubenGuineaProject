
/*TODO Studiare come funziona il focus sui widget in modo da poter selezionare il testo gia presente
*  quando ci clicchi sopra e scrivere senza dover cancellare*/


package com.pideruben.guineaproject.application.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.pideruben.guineaproject.api.DipendentiApiService;
import com.pideruben.guineaproject.application.MainActivity;
import com.pideruben.guineaproject.R;
import com.pideruben.guineaproject.domain.Dipendente;
import com.pideruben.guineaproject.domain.ListaDipendenti;
import com.pideruben.guineaproject.persistence.AppDatabase;
import com.pideruben.guineaproject.persistence.EntityDipendente;
import com.pideruben.guineaproject.utilities.ServiceLocator;

import java.util.ArrayList;
import java.util.List;

import javax.microedition.khronos.egl.EGLDisplay;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private AppDatabase db;
    private ArrayList<EntityDipendente> listaDipendenti;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Fetch lista dipendenti

        ArrayList<Dipendente> dipendenti = new ArrayList<>();
        DipendentiApiService dipendentiApiService = ServiceLocator.getDipendentiApiService();
        EditText username = findViewById(R.id.editTextTextPersonName);
        EditText password = findViewById(R.id.editTextTextPassword);
        db = AppDatabase.getDatabase(this);

        dipendentiApiService.getDipendenti().enqueue(
                new Callback<ListaDipendenti>() {
                    //private List<Dipendente> dipendenti = new ArrayList<>();

                    @Override
                    public void onResponse(Call<ListaDipendenti> call, Response<ListaDipendenti> response) {
                        if(!response.isSuccessful())
                            System.out.println("error");
                            //make toast
                        else{
                            dipendenti.addAll(response.body().getDipendenti());
                            Log.i("ok", "ok");
                            for(Dipendente d : dipendenti)
                                Log.i("dip", d.getNome());
                            for (Dipendente d : dipendenti)
                                db.daoDipendenti().inserisciDipendente(new EntityDipendente(d));

                            listaDipendenti = (ArrayList<EntityDipendente>) db.daoDipendenti().getDipendenti();
                            for (EntityDipendente d : listaDipendenti)
                                Log.i("dipdb", d.nome);
                        }
                    }

                    @Override
                    public void onFailure(Call<ListaDipendenti> call, Throwable t) {
                        Log.i("err", "err");
                    }
                }
        );



        //aggiorna db



        final Button loginButton = findViewById(R.id.buttonLogin);
        loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                String user = username.getText().toString();
                String psw = password.getText().toString();

                try {
                    for (EntityDipendente d : listaDipendenti) {
                        String nome = user.substring(0, user.indexOf("."));
                        String cognome = user.substring(user.indexOf(".") + 1);
                        if (d.nome.compareToIgnoreCase(nome) == 0 &&
                                d.cognome.compareToIgnoreCase(cognome) == 0 &&
                                d.password.compareTo(psw) == 0) {
                            //login success
                            Intent myIntent = new Intent(v.getContext(), PostLoginActivity.class);
                            startActivity(myIntent);
                            finish();
                        } else {
                            final Snackbar sb = Snackbar.make(v, R.string.erroreNoPersone, Snackbar.LENGTH_SHORT);
                            sb.setAction(R.string.snackbarActionChiudi, view1 -> {
                                sb.dismiss();
                            }).show();
                            username.setText("");
                            password.setText("");
                        }
                    }
                }catch(IndexOutOfBoundsException e){
                    username.setText("");
                    password.setText("");
                }
            }
        });

        /*final ImageButton helpImageButton = findViewById(R.id.imageButtonHelp);
        helpImageButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.i("Login", "Hai richiesto aiuto");
            }
        });*/

    }

}
