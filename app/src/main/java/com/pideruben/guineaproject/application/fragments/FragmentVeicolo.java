package com.pideruben.guineaproject.application.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pideruben.guineaproject.R;

import org.w3c.dom.Text;


public class FragmentVeicolo extends Fragment {

    private TextView Targa;
    private TextView KmEffettuati;
    private TextView Modello;
    private TextView AllarmeManutenzione;
    private TextView Carburante;


    public FragmentVeicolo() {
        // Required empty public constructor
    }

    public static FragmentVeicolo newInstance(String param1, String param2) {
        FragmentVeicolo fragment = new FragmentVeicolo();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_veicolo, container, false);

        Targa = view.findViewById(R.id.tx_targa);
        KmEffettuati = view.findViewById(R.id.tx_kmEffettuati);
        Modello = view.findViewById(R.id.tx_modello);
        AllarmeManutenzione = view.findViewById(R.id.tx_allarme);
        Carburante = view.findViewById(R.id.tx_Carburante);

        return view;
    }
}