package com.prueba.androidlistas;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Fragment f1 = new BlankFragment();
        ft.add(R.id.fragment_add,f1);
        ft.commit();

        Fragment f2 = new FragmentoLista();
        ft = fm.beginTransaction();
        ft.add(R.id.fragment_add,f2);
        ft.commit();

    }
}
