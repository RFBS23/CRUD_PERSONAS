package com.fabridev.crudSenati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class menuOpciones extends AppCompatActivity {
    TextView txtRegistrar, txtBuscar, txtActualizar;
    ImageView imgRegistrar, imgBuscar, imgActualizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opciones);
        txtRegistrar = findViewById(R.id.txtRegistrar);
        imgRegistrar = findViewById(R.id.imgRegistrar);
        txtBuscar = findViewById(R.id.txtBuscar);
        imgBuscar = findViewById(R.id.imgBuscar);
        txtActualizar = findViewById(R.id.txtActualizar);
        imgActualizar = findViewById(R.id.imgActualizar);

        txtRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarPersona();
            }
        });
        imgRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarPersona();
            }
        });
        txtBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscarPersonas();
            }
        });
        imgBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscarPersonas();
            }
        });
        txtActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActualizarPersonas();
            }
        });
        imgActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActualizarPersonas();
            }
        });
    }
    private void registrarPersona(){
        Intent intent = new Intent(this, Registrar.class);
        startActivity(intent);
    }

    private void buscarPersonas(){
        Intent intent = new Intent(this, Buscar.class);
        startActivity(intent);
    }

    private void ActualizarPersonas(){
        Intent intent = new Intent(this, actualizar.class);
        startActivity(intent);
    }
}