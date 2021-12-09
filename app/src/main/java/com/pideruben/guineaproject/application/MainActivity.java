package com.pideruben.guineaproject.application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.pideruben.guineaproject.application.fragments.FragmentBiglietto;
import com.pideruben.guineaproject.R;
import com.pideruben.guineaproject.application.fragments.FragmentVeicolo;
import com.pideruben.guineaproject.application.login.LoginActivity;
import com.pideruben.guineaproject.persistence.AppDatabase;
import com.pideruben.guineaproject.persistence.EntityCorsa;

import org.jetbrains.annotations.NotNull;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AppDatabase db = AppDatabase.getDatabase(this);
        if (db.daoCorse().getAllCorsa().isEmpty()){
            Date date = new Date();
            DateFormat dateFormat = android.text.format.DateFormat.getLongDateFormat(this);
            String dataOggi = dateFormat.format(date);
            EntityCorsa prova = new EntityCorsa(1,false, "data pacca");
            db.daoCorse().inserisciCorsa(prova);
            Log.i("MainActivity", "riga inserita");

        }
        GestisciCorsa();


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentBiglietto()).commit();

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false); //visibilita titolo
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.main_bg_color))); //colore toolbar

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.black)); //colore hanburger


        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.fragment_biglietto,null);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentBiglietto()).commit();
                break;
            case R.id.nav_veicolo:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentVeicolo()).commit();
                break;
            case R.id.nav_Account:
                finish();
                Intent myIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(myIntent);
                break;
            case R.id.nav_terminaCorsa:
                AppDatabase db = AppDatabase.getDatabase(this);
                List<EntityCorsa> entity_corsa  = db.daoCorse().getAllCorsa();
                EntityCorsa corsa = entity_corsa.get(0);
                int progressivoCorsa = corsa.nCorsa;
                String data = corsa.data;
                db.daoCorse().deleteCorsa(corsa);
                db.daoCorse().inserisciCorsa(new EntityCorsa(progressivoCorsa, false, data));
                GestisciCorsa();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentBiglietto()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }


    void GestisciCorsa(){
        AppDatabase db = AppDatabase.getDatabase(getApplicationContext());
        List<EntityCorsa> entity_corsa  = db.daoCorse().getAllCorsa();
        EntityCorsa corsa = entity_corsa.get(0);
        int progressivoCorsa = corsa.nCorsa;
        String data = corsa.data;
        boolean isOnRoad = corsa.isOnRoad;

        Date date = new Date();
        DateFormat dateFormat = android.text.format.DateFormat.getLongDateFormat(this);
        String dataOggi = dateFormat.format(date);

        if(data.compareTo(dataOggi)==0){
            if(!isOnRoad){
                db.daoCorse().deleteCorsa(corsa);
                EntityCorsa nuovaCorsa = new EntityCorsa(progressivoCorsa+1, true, data);
                db.daoCorse().inserisciCorsa(nuovaCorsa);
            }
        }
        else{
            db.daoCorse().deleteCorsa(corsa);
            EntityCorsa nuovaCorsa = new EntityCorsa(1, false, dataOggi);
            db.daoCorse().inserisciCorsa(nuovaCorsa);
        }
    }
}