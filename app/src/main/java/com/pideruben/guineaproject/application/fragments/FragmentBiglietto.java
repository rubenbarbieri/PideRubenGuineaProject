package com.pideruben.guineaproject.application.fragments;


import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
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

import com.pideruben.guineaproject.R;

import org.jetbrains.annotations.NotNull;

import java.text.DateFormat;
import java.util.Date;

public class FragmentBiglietto extends Fragment {
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_biglietto, container, false);

        //Spinner
        Spinner spinnerFrom = view.findViewById(R.id.spFrom);
        Spinner spinnerTo = view.findViewById(R.id.spTo);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(), R.array.spinnerFermate, R.layout.color_spinner_ly);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);

        //Imposto la data nella textview
        Date date = new Date();
        DateFormat dateFormat = android.text.format.DateFormat.getLongDateFormat(view.getContext());
        TextView Date = view.findViewById(R.id.tx_date);
        Date.setText(dateFormat.format(date));


        //PULSANTI aggiungi/togli persone
        Button plusAdult = view.findViewById(R.id.plusAdults);
        plusAdult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        Button minusAdult = view.findViewById(R.id.minusAdults);
        minusAdult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Button plusChildren = view.findViewById(R.id.plusChildren);
        plusChildren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        Button minusChildren = view.findViewById(R.id.minusChildren);
        minusChildren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Button plusStudent = view.findViewById(R.id.plusStudent);
        plusStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        Button minusStudent = view.findViewById(R.id.minusStudent);
        minusStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Button plusInvalid = view.findViewById(R.id.plusInvalid);
        plusInvalid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        Button minusInvalid = view.findViewById(R.id.minusInvalid);
        minusInvalid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //PULSANTI aggiungi/togli bagagli

        Button plusBigLuggage = view.findViewById(R.id.plusBigLuggage);
        plusBigLuggage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        Button minusBigLuggage = view.findViewById(R.id.minusBigLuggage);
        minusBigLuggage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Button plusMediumLuggage = view.findViewById(R.id.plusMediumLuggage);
        plusMediumLuggage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        Button minusMediumLuggage = view.findViewById(R.id.minusMediumLuggage);
        minusMediumLuggage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Button plusSmallLuggage = view.findViewById(R.id.plusSmallLuggage);
        plusSmallLuggage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        Button minusSmallLuggage = view.findViewById(R.id.minusSmallLuggage);
        minusSmallLuggage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //PULSANTE Conferma Biglietto
        Button confirmRide = view.findViewById(R.id.confirm_ride);
        confirmRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



        return view;
    }
}
