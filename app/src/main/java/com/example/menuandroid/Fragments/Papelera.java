package com.example.menuandroid.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.menuandroid.R;


public class Papelera extends Fragment {

    public Papelera() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.papelera_layout, container, false);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        // aqui introduces el codigo necesario para obtener los datos
        // como llamar a la base de datos o acceder a un archivo
        // depende de como gestiones tus archivos
    }

}
