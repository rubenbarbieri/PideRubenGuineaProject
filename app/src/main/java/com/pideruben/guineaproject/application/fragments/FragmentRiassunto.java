package com.pideruben.guineaproject.application.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.pideruben.guineaproject.R;
import com.pideruben.guineaproject.persistence.AppDatabase;
import com.pideruben.guineaproject.persistence.EntityBiglietto;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FragmentRiassunto extends Fragment {

    public FragmentRiassunto() {

    }

    public static FragmentRiassunto newInstance(String param1, String param2) {
        FragmentRiassunto fragment = new FragmentRiassunto();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }
    String Adulti;
    String Bambini;
    String Studenti;
    String Ammalati;
    String SmallLuggage;
    String MediumLuggage;
    String BigLuggage;
    String TotaleCorsa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_riassunto, container, false);

        Date date = new Date();
        DateFormat dateFormat = android.text.format.DateFormat.getLongDateFormat(getContext());
        String dataOggi = dateFormat.format(date);

        TableLayout tl = (TableLayout) view.findViewById(R.id.tableRiassuntivoCorse);
        AppDatabase db = AppDatabase.getDatabase(getContext());
        List<EntityBiglietto> dbBiglietti = db.daoBiglietto().getAllBiglietti();

        List<Integer> numAdultiperCorsa;
        List<Integer> numBambiniCorsa;
        List<Integer> numStudentiCorsa;
        List<Integer> numInvalidiCorsa;
        List<Integer> numSmallLugageCorsa;
        List<Integer> numMediumLuggageCorsa;
        List<Integer> numBigLuggageCorsa;


        ArrayList<Integer> arrayTotaliAdulti = new ArrayList<Integer>(); //Contiene i totali degli audlti delle corse totali
        ArrayList<Integer> arrayTotaliBambini = new ArrayList<Integer>();
        ArrayList<Integer> arrayTotaliStudenti= new ArrayList<Integer>();
        ArrayList<Integer> arrayTotaliInvalidi= new ArrayList<Integer>();
        ArrayList<Integer> arrayTotaliSmall= new ArrayList<Integer>();
        ArrayList<Integer> arrayTotaliMedium= new ArrayList<Integer>();
        ArrayList<Integer> arrayTotaliBig= new ArrayList<Integer>();

        int totaleAdulti;
        int totaleBambini;
        int totaleStudenti;
        int totaleInvalidi;
        int totaleSmall;
        int totaleMedium;
        int totaleBig;

        //Ottengo i totali per corsa e li salvo negli array precedenti NB:size degli array coincide con il numero di corse;
        for(int corsa=1; corsa<=dbBiglietti.get(dbBiglietti.size()-1).n_corsa; corsa++) {
            numAdultiperCorsa = db.daoBiglietto().getAdultiCorsaData(corsa,dataOggi);
            numBambiniCorsa = db.daoBiglietto().getBambiniCorsaData(corsa, dataOggi);
            numStudentiCorsa = db.daoBiglietto().getStudentiCorsaData(corsa, dataOggi);
            numInvalidiCorsa = db.daoBiglietto().getInvalidiCorsaData(corsa, dataOggi);
            numSmallLugageCorsa = db.daoBiglietto().getSmallLugageCorsaData(corsa, dataOggi);
            numMediumLuggageCorsa = db.daoBiglietto().getMediumLuggageCorsaData(corsa, dataOggi);
            numBigLuggageCorsa = db.daoBiglietto().getBigLuggageCorsaData(corsa, dataOggi);
            totaleAdulti = 0;
            totaleBambini = 0;
            totaleStudenti = 0;
            totaleInvalidi = 0;
            totaleBig = 0;
            totaleMedium = 0;
            totaleSmall = 0;
            for (int i = 0; i < numAdultiperCorsa.size(); i++) {
                totaleAdulti = totaleAdulti + numAdultiperCorsa.get(i);
                totaleBambini = totaleBambini + numBambiniCorsa.get(i);
                totaleStudenti = totaleStudenti + numStudentiCorsa.get(i);
                totaleInvalidi = totaleInvalidi + numInvalidiCorsa.get(i);
                totaleSmall = totaleSmall + numSmallLugageCorsa.get(i);
                totaleMedium = totaleMedium + numMediumLuggageCorsa.get(i);
                totaleBig = totaleBig + numBigLuggageCorsa.get(i);
            }
            arrayTotaliAdulti.add(totaleAdulti);
            arrayTotaliBambini.add(totaleBambini);
            arrayTotaliStudenti.add(totaleStudenti);
            arrayTotaliInvalidi.add(totaleInvalidi);
            arrayTotaliBig.add(totaleBig);
            arrayTotaliMedium.add(totaleMedium);
            arrayTotaliSmall.add(totaleSmall);
        }

        //Stampo su tabella
        TableRow rowAdulti = new TableRow(getContext());
        for(int j = 0; j<arrayTotaliAdulti.size(); j++){
            Adulti = Integer.toString(arrayTotaliAdulti.get(j));
            TextView nAdulti = new TextView(getContext());
            nAdulti.setText(Adulti);
            nAdulti.setTextColor(Color.parseColor("#000000"));
            rowAdulti.addView(nAdulti);
        }
        tl.addView(rowAdulti, new TableLayout.LayoutParams());

        TableRow rowBambini = new TableRow(getContext());
        for(int corsa = 0; corsa<arrayTotaliBambini.size(); corsa++){
            Bambini = Integer.toString(arrayTotaliBambini.get(corsa));
            TextView nBambini = new TextView(getContext());
            nBambini.setText(Bambini);
            nBambini.setTextColor(Color.parseColor("#000000"));
            rowBambini.addView(nBambini);
        }
        tl.addView(rowBambini, new TableLayout.LayoutParams());

        TableRow rowStudenti = new TableRow(getContext());
        for(int corsa = 0; corsa<arrayTotaliStudenti.size(); corsa++){
            Studenti = Integer.toString(arrayTotaliStudenti.get(corsa));
            TextView nStudenti = new TextView(getContext());
            nStudenti.setText(Bambini);
            nStudenti.setTextColor(Color.parseColor("#000000"));
            rowStudenti.addView(nStudenti);

        }
        tl.addView(rowStudenti, new TableLayout.LayoutParams());

        TableRow rowInvalidi = new TableRow(getContext());
        for(int corsa = 0; corsa<arrayTotaliInvalidi.size(); corsa++){
            Ammalati = Integer.toString(arrayTotaliInvalidi.get(corsa));
            TextView nInvalidi = new TextView(getContext());
            nInvalidi.setText(Ammalati);
            nInvalidi.setTextColor(Color.parseColor("#000000"));
            rowInvalidi.addView(nInvalidi);
        }
        tl.addView(rowInvalidi, new TableLayout.LayoutParams());

        TableRow rowBig = new TableRow(getContext());
        for(int corsa = 0; corsa<arrayTotaliBig.size(); corsa++){
            BigLuggage = Integer.toString(arrayTotaliBig.get(corsa));
            TextView nBig = new TextView(getContext());
            nBig.setText(BigLuggage);
            nBig.setTextColor(Color.parseColor("#000000"));
            rowBig.addView(nBig);
        }
        tl.addView(rowBig, new TableLayout.LayoutParams());

        TableRow rowMedium = new TableRow(getContext());
        for(int corsa = 0; corsa<arrayTotaliMedium.size(); corsa++){
            MediumLuggage = Integer.toString(arrayTotaliMedium.get(corsa));
            TextView nMedium = new TextView(getContext());
            nMedium.setText(MediumLuggage);
            nMedium.setTextColor(Color.parseColor("#000000"));
            rowMedium.addView(nMedium);
        }
        tl.addView(rowMedium, new TableLayout.LayoutParams());

        TableRow rowSmall = new TableRow(getContext());
        for(int corsa = 0; corsa<arrayTotaliSmall.size(); corsa++){
            SmallLuggage = Integer.toString(arrayTotaliSmall.get(corsa));
            TextView nSmall = new TextView(getContext());
            nSmall.setText(BigLuggage);
            nSmall.setTextColor(Color.parseColor("#000000"));
            rowSmall.addView(nSmall);
        }
        tl.addView(rowSmall, new TableLayout.LayoutParams());

        /*
       for (int x = 0; x < dbBiglietti.get(dbBiglietti.size()-1).n_corsa; x++) {

            Adulti = "Adulti: " + Integer.toString(dbBiglietti.get(x).n_adulti);
            Bambini = Integer.toString(dbBiglietti.get(x).n_bambini);
            Studenti = Integer.toString(dbBiglietti.get(x).n_studenti);
            Ammalati = Integer.toString(dbBiglietti.get(x).n_invalidi);
            SmallLuggage = Integer.toString(dbBiglietti.get(x).n_bagagli_piccoli);
            MediumLuggage = Integer.toString(dbBiglietti.get(x).n_bagagli_medi);
            BigLuggage = Integer.toString(dbBiglietti.get(x).n_bagagli_grandi);
            TotaleCorsa = Integer.toString(dbBiglietti.get(x).prezzo);


            TableRow newRow = new TableRow(getContext());

            TextView nAdulti = new TextView(getContext());

            TextView nBambini = new TextView(getContext());
            TextView nStudenti = new TextView(getContext());
            TextView nDisabili = new TextView(getContext());
            TextView nSmall = new TextView(getContext());
            TextView nMedium = new TextView(getContext());
            TextView nBig = new TextView(getContext());
            TextView totaleCorsa = new TextView(getContext());

            nAdulti.setText(Adulti);
            nAdulti.setTextColor(Color.parseColor("#000000"));

            nBambini.setText(Bambini);
            nBambini.setTextColor(Color.parseColor("#000000"));

            nStudenti.setText(Studenti);
            nStudenti.setTextColor(Color.parseColor("#000000"));

            nDisabili.setText(Ammalati);
            nDisabili.setTextColor(Color.parseColor("#000000"));

            nSmall.setText(SmallLuggage);
            nSmall.setTextColor(Color.parseColor("#000000"));

            nMedium.setText(MediumLuggage);
            nMedium.setTextColor(Color.parseColor("#000000"));

            nBig.setText(BigLuggage);
            nBig.setTextColor(Color.parseColor("#000000"));



            newRow.addView(nAdulti);

            newRow.addView(nBambini);
            newRow.addView(nStudenti);
            newRow.addView(nDisabili);
            newRow.addView(nSmall);
            newRow.addView(nMedium);
            newRow.addView(nBig);
            tl.addView(newRow, new TableLayout.LayoutParams());
        }
        */

       return view;
    }
}