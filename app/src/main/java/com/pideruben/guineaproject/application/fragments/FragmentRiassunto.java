package com.pideruben.guineaproject.application.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pideruben.guineaproject.R;

public class FragmentRiassunto extends Fragment {

    public FragmentRiassunto() {

    }


    // TODO: Rename and change types and number of parameters
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_riassunto, container, false);



       return view;
    }
}