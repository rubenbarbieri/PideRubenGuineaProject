package com.pideruben.guineaproject.application.fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.telephony.euicc.DownloadableSubscription;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.pideruben.guineaproject.R;
import com.pideruben.guineaproject.persistence.AppDatabase;
import com.pideruben.guineaproject.persistence.EntityBiglietto;
import com.pideruben.guineaproject.persistence.EntityCorsa;
import com.pideruben.guineaproject.values.Prezzi;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import io.reactivex.rxjava3.internal.operators.single.SingleFlatMapBiSelector;

public class FragmentBiglietto extends Fragment {

    private String TAG = "FragmentBiglietto";

    private Spinner spinnerFrom;
    private Spinner spinnerTo;

    private TextView date_tv;

    private TextView nAdults;
    private TextView nChildren;
    private TextView nStudents;
    private TextView nInvalidi;

    private TextView nBigLuggage;
    private TextView nMediumLuggage;
    private TextView nSmallLuggage;

    private TextView costoTotale;
    private TextView nCorsa;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_biglietto, container, false);

        //Spinner
        spinnerFrom = view.findViewById(R.id.spFrom);
        spinnerTo = view.findViewById(R.id.spTo);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(), R.array.spinnerFermate, R.layout.color_spinner_ly);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);

        //Imposto la data nella textview
        Date date = new Date();
        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(view.getContext());
        date_tv = view.findViewById(R.id.tx_date);
        date_tv.setText(dateFormat.format(date));

        costoTotale = view.findViewById(R.id.totaleDaPagare);
        nAdults = view.findViewById(R.id.nAdults);
        nChildren = view.findViewById(R.id.nChildren);
        nStudents = view.findViewById(R.id.nStudents);
        nInvalidi = view.findViewById(R.id.nInvalid);


        //Numero Corsa
        nCorsa = view.findViewById(R.id.nCorsa);
        AppDatabase db = AppDatabase.getDatabase(this.getContext());
        List<EntityCorsa> entity_corsa  = db.daoCorse().getAllCorsa();
        EntityCorsa corsa = entity_corsa.get(0);
        int progressivoCorsa = corsa.nCorsa;
        nCorsa.setText(Integer.toString(progressivoCorsa));

        //PULSANTI aggiungi/togli persone
        Button plusAdult = view.findViewById(R.id.plusAdults);
        plusAdult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nAdults.setText(Integer.toString(Integer.parseInt(nAdults.getText().toString())+1));
                costoTotale.setText(String.format("%.0f", Double.parseDouble(costoTotale.getText().toString())
                        + Prezzi.prezzoAdulto));
            }
        });
        Button minusAdult = view.findViewById(R.id.minusAdults);
        minusAdult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(nAdults.getText().toString())>0){
                    nAdults.setText(Integer.toString(Integer.parseInt(nAdults.getText().toString())-1));
                    costoTotale.setText(String.format("%.0f", Double.parseDouble(costoTotale.getText().toString())
                            - Prezzi.prezzoAdulto));
                }
            }
        });

        Button plusChildren = view.findViewById(R.id.plusChildren);
        plusChildren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nChildren.setText(Integer.toString(Integer.parseInt(nChildren.getText().toString())+1));
                costoTotale.setText(String.format("%.0f", Double.parseDouble(costoTotale.getText().toString())
                        + Prezzi.prezzoBambino));
            }
        });
        Button minusChildren = view.findViewById(R.id.minusChildren);
        minusChildren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(nChildren.getText().toString())>0){
                    nChildren.setText(Integer.toString(Integer.parseInt(nChildren.getText().toString())-1));
                    costoTotale.setText(String.format("%.0f", Double.parseDouble(costoTotale.getText().toString())
                            - Prezzi.prezzoBambino));
                }
            }
        });

        Button plusStudent = view.findViewById(R.id.plusStudent);
        plusStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nStudents.setText(Integer.toString(Integer.parseInt(nStudents.getText().toString())+1));
                costoTotale.setText(String.format("%.0f", Double.parseDouble(costoTotale.getText().toString())
                        + Prezzi.prezzoStudente));
            }
        });
        Button minusStudent = view.findViewById(R.id.minusStudent);
        minusStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(nStudents.getText().toString())>0){
                    nStudents.setText(Integer.toString(Integer.parseInt(nStudents.getText().toString())-1));
                    costoTotale.setText(String.format("%.0f", Double.parseDouble(costoTotale.getText().toString())
                            - Prezzi.prezzoStudente));
                }
            }
        });

        Button plusInvalid = view.findViewById(R.id.plusInvalid);
        plusInvalid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nInvalidi.setText(Integer.toString(Integer.parseInt(nInvalidi.getText().toString())+1));
                costoTotale.setText(String.format("%.0f", Double.parseDouble(costoTotale.getText().toString())
                        + Prezzi.prezzoInvalido));
            }
        });
        Button minusInvalid = view.findViewById(R.id.minusInvalid);
        minusInvalid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(nInvalidi.getText().toString())>0){
                    nInvalidi.setText(Integer.toString(Integer.parseInt(nInvalidi.getText().toString())-1));
                    costoTotale.setText(String.format("%.0f", Double.parseDouble(costoTotale.getText().toString())
                            - Prezzi.prezzoInvalido));
                }
            }
        });

        //PULSANTI aggiungi/togli bagagli

        nBigLuggage = view.findViewById(R.id.nBigLuggage);
        nMediumLuggage = view.findViewById(R.id.nMediumLuggage);
        nSmallLuggage = view.findViewById(R.id.nSmallLuggage);

        Button plusBigLuggage = view.findViewById(R.id.plusBigLuggage);
        plusBigLuggage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nBigLuggage.setText(Integer.toString(Integer.parseInt(nBigLuggage.getText().toString())+1));
                costoTotale.setText(String.format("%.0f", Double.parseDouble(costoTotale.getText().toString())  + Prezzi.prezzoBigLuggage));
            }
        });
        Button minusBigLuggage = view.findViewById(R.id.minusBigLuggage);
        minusBigLuggage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(nBigLuggage.getText().toString())>0){
                    nBigLuggage.setText(Integer.toString(Integer.parseInt(nBigLuggage.getText().toString())-1));
                    costoTotale.setText(String.format("%.0f", Double.parseDouble(costoTotale.getText().toString())  - Prezzi.prezzoBigLuggage));
                }
            }
        });

        Button plusMediumLuggage = view.findViewById(R.id.plusMediumLuggage);
        plusMediumLuggage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nMediumLuggage.setText(Integer.toString(Integer.parseInt(nMediumLuggage.getText().toString())+1));
                costoTotale.setText(String.format("%.0f", Double.parseDouble(costoTotale.getText().toString())  + Prezzi.prezzoMediumLuggage));
            }
        });
        Button minusMediumLuggage = view.findViewById(R.id.minusMediumLuggage);
        minusMediumLuggage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(nMediumLuggage.getText().toString())>0){
                    nMediumLuggage.setText(Integer.toString(Integer.parseInt(nMediumLuggage.getText().toString())-1));
                    costoTotale.setText(String.format("%.0f", Double.parseDouble(costoTotale.getText().toString())  - Prezzi.prezzoMediumLuggage));
                }
            }
        });

        Button plusSmallLuggage = view.findViewById(R.id.plusSmallLuggage);
        plusSmallLuggage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nSmallLuggage.setText(Integer.toString(Integer.parseInt(nSmallLuggage.getText().toString())+1));
                costoTotale.setText(String.format("%.0f", Double.parseDouble(costoTotale.getText().toString()) + Prezzi.prezzoSmallLuggage));
            }
        });
        Button minusSmallLuggage = view.findViewById(R.id.minusSmallLuggage);
        minusSmallLuggage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(nSmallLuggage.getText().toString())>0){
                    nSmallLuggage.setText(Integer.toString(Integer.parseInt(nSmallLuggage.getText().toString())-1));
                    costoTotale.setText(String.format("%.0f", Double.parseDouble(costoTotale.getText().toString())  - Prezzi.prezzoSmallLuggage));
                }
            }
        });


        //PULSANTE Conferma Biglietto
        Button confirmRide = view.findViewById(R.id.confirm_ride);
        confirmRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "checking...");
                if(checkCampi()){
                    ShowDialog();
                }
            }
        });

        return view;
    }

    private void ShowDialog(){
        View v = getView();
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        builder.setCancelable(true);
        builder.setTitle("Resumo");

        builder.setMessage("Adultos: "+ ((TextView)(v.findViewById(R.id.nAdults))).getText()
                + "\nCrianças: " + ((TextView)(v.findViewById(R.id.nChildren))).getText()
                + "\nEstudantes: " + ((TextView)(v.findViewById(R.id.nStudents))).getText()
                + "\nInválidos: " + ((TextView)(v.findViewById(R.id.nInvalid))).getText()
                + "\n\nBagagem: "
                + "\n   pequeno: " + ((TextView)(v.findViewById(R.id.nSmallLuggage))).getText()
                + "\n   médio: " + ((TextView)(v.findViewById(R.id.nMediumLuggage))).getText()
                + "\n   grande: " + ((TextView)(v.findViewById(R.id.nBigLuggage))).getText()
                + "\n\n\nTotal: " + ((TextView)(v.findViewById(R.id.totaleDaPagare))).getText() + " FCFA"
        );
        builder.setPositiveButton("Confirm",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        inserisciBiglietto();
                        resetCampi();
                    }
                });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void inserisciBiglietto(){
        AppDatabase db = AppDatabase.getDatabase(this.getContext());
        View v = getView();

        nAdults = v.findViewById(R.id.nAdults);
        int adults = Integer.parseInt(nAdults.getText().toString());
        nChildren = v.findViewById(R.id.nChildren);
        int children = Integer.parseInt(nChildren.getText().toString());
        nStudents = v.findViewById(R.id.nStudents);
        int students = Integer.parseInt(nStudents.getText().toString());
        nInvalidi = v.findViewById(R.id.nInvalid);
        int invalids = Integer.parseInt(nInvalidi.getText().toString());

        // ... retrieve luggages ...
        nSmallLuggage = v.findViewById(R.id.nSmallLuggage);
        int nBagagliPiccoli = Integer.parseInt(nSmallLuggage.getText().toString());
        nMediumLuggage = v.findViewById(R.id.nMediumLuggage);
        int nBagagliMedi = Integer.parseInt(nMediumLuggage.getText().toString());
        nBigLuggage = v.findViewById(R.id.nBigLuggage);
        int nBagagliColossali = Integer.parseInt(nBigLuggage.getText().toString());

        // ... retrieve date ...
        date_tv = v.findViewById(R.id.tx_date);
        String data = date_tv.getText().toString();

        // ... retrieve tratta ...
        spinnerFrom = v.findViewById(R.id.spFrom);
        String da = spinnerFrom.getSelectedItem().toString();
        String tratta = spinnerFrom.getSelectedItem().toString();
        spinnerTo = v.findViewById(R.id.spTo);
        String a = spinnerTo.getSelectedItem().toString();
        tratta += " to " + spinnerTo.getSelectedItem().toString();

        //Retrive prezzo
        TextView prezzo = v.findViewById(R.id.totaleDaPagare);
        int prezzoTotale = Integer.parseInt(prezzo.getText().toString());

        //Retrieve targa
        String targa = "AA000AA";

        TextView corsa = v.findViewById(R.id.nCorsa);
        int n_corsa = Integer.parseInt(corsa.getText().toString());

        //Create records

        EntityBiglietto biglietto = new EntityBiglietto(adults, children, students, invalids,
                nBagagliPiccoli, nBagagliMedi, nBagagliColossali, data, tratta, targa, n_corsa, prezzoTotale, da, a);
        Log.i("Main:", biglietto.toString());
        db.daoBiglietto().inserisciBiglietto(biglietto);
        for(EntityBiglietto b : db.daoBiglietto().getAllBiglietti())
            Log.i("DB:", b.toString());

        final Snackbar sb = Snackbar.make(v, R.string.bigliettoCorretto, Snackbar.LENGTH_SHORT);
        sb.setAction(R.string.snackbarActionChiudi, view1 -> {
            sb.dismiss();
        }).show();
    }

    private void resetCampi(){

        View view = getView();

        costoTotale = view.findViewById(R.id.totaleDaPagare);
        nAdults = view.findViewById(R.id.nAdults);
        nChildren = view.findViewById(R.id.nChildren);
        nStudents = view.findViewById(R.id.nStudents);
        nInvalidi = view.findViewById(R.id.nInvalid);

        nBigLuggage = view.findViewById(R.id.nBigLuggage);
        nMediumLuggage = view.findViewById(R.id.nMediumLuggage);
        nSmallLuggage = view.findViewById(R.id.nSmallLuggage);

        costoTotale.setText("0");

        nAdults.setText("0");
        nChildren.setText("0");
        nStudents.setText("0");
        nInvalidi.setText("0");

        nBigLuggage.setText("0");
        nMediumLuggage.setText("0");
        nSmallLuggage.setText("0");

    }

    private boolean checkCampi(){

        View view = getView();

        spinnerFrom = view.findViewById(R.id.spFrom);
        spinnerTo = view.findViewById(R.id.spTo);
        date_tv = view.findViewById(R.id.tx_date);
        nAdults = view.findViewById(R.id.nAdults);
        nChildren = view.findViewById(R.id.nChildren);
        nStudents = view.findViewById(R.id.nStudents);
        nInvalidi = view.findViewById(R.id.nInvalid);
        nSmallLuggage = view.findViewById(R.id.nSmallLuggage);
        nMediumLuggage = view.findViewById(R.id.nMediumLuggage);
        nBigLuggage = view.findViewById(R.id.nBigLuggage);
        costoTotale = view.findViewById(R.id.totaleDaPagare);

        if(spinnerFrom.getSelectedItem().toString().compareTo(spinnerTo.getSelectedItem().toString()) == 0){
            Log.i(TAG, "fermate uguali");
            final Snackbar sb = Snackbar.make(view, R.string.erroreFermate, Snackbar.LENGTH_SHORT);
            sb.setAction(R.string.snackbarActionChiudi, view1 -> {
                sb.dismiss();
            }).show();
            return false;
        }

        else if(nAdults.getText().toString().compareTo("0") == 0 &&
                nChildren.getText().toString().compareTo("0") == 0 &&
                nStudents.getText().toString().compareTo("0") == 0 &&
                nInvalidi.getText().toString().compareTo("0") == 0){
            final Snackbar sb = Snackbar.make(view, R.string.erroreNoPersone, Snackbar.LENGTH_SHORT);
            sb.setAction(R.string.snackbarActionChiudi, view1 -> {
                sb.dismiss();
            }).show();
            return false;
        }


        return true;
    }

}
