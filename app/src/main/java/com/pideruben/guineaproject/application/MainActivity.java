package com.pideruben.guineaproject.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.pideruben.guineaproject.R;
import com.pideruben.guineaproject.persistence.AppDatabase;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}