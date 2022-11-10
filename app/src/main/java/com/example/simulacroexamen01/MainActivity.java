package com.example.simulacroexamen01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.simulacroexamen01.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private int cigarros;
    private int dinero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        cigarros = 20;
        dinero = 0;

        actualizarVistas();

        binding.btnCambiarMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cigarros > 1) {
                    cigarros--;
                    actualizarVistas();
                }
                else {
                    cigarros = 20;
                    dinero += 5;
                    actualizarVistas();
                }
            }
        });
    }

    private void actualizarVistas(){
        binding.txtContadorMain.setText(String.valueOf(cigarros));
        binding.txtAhorradoMain.setText(String.valueOf(dinero));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("CIGARROS", cigarros);
        outState.putInt("DINERO", dinero);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        cigarros = savedInstanceState.getInt("CIGARROS");
        dinero = savedInstanceState.getInt("DINERO");
    }
}