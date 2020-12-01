package com.example.duolingo_.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.Spinner;

import com.example.duolingo_.Exercicies;
import com.example.duolingo_.Exercicies5;
import com.example.duolingo_.MainActivity;
import com.example.duolingo_.R;

import java.util.ArrayList;
import java.util.Arrays;

public class CursFragment extends Fragment {

    Button button3, button5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_curs, container, false);


        button3 = view.findViewById(R.id.button3);

        button5 = view.findViewById(R.id.button5);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CursFragment cursFragment = new CursFragment();
                Exercicies exercicies = new Exercicies();

                Intent intent = new Intent(getActivity(), Exercicies.class);
                startActivity(intent);

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CursFragment cursFragment = new CursFragment();
                Exercicies5 exercicies5 = new Exercicies5();

                Intent intent = new Intent(getActivity(), Exercicies5.class);
                startActivity(intent);

            }
        });

        return view;
    }

}