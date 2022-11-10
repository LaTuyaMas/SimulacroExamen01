package com.example.simulacroexamen01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.simulacroexamen01.databinding.ActivityMainBinding;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private final int cantidad_cigarros = 20;
    private final int precio_paquete = 5;

    private int cigarros = 20;
    private int dinero = 0;

    //Formato numeros
    private NumberFormat numberFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        numberFormat = NumberFormat.getCurrencyInstance();

        actualizarVistas();

        binding.btnCambiarMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cigarros > 1) {
                    cigarros--;
                    actualizarVistas();
                }
                else {
                    cigarros = cantidad_cigarros;
                    dinero += precio_paquete;
                    actualizarVistas();
                }
            }
        });
    }

    private void actualizarVistas(){
        binding.txtContadorMain.setText(String.valueOf(cigarros));
        binding.txtAhorradoMain.setText(numberFormat.format(dinero));
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