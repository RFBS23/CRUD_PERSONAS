package com.fabridev.crudSenati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class menuOpciones extends AppCompatActivity {
    TextView txtRegistrar;
    ImageView imgRegistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opciones);
        txtRegistrar = findViewById(R.id.txtRegistrar);
        imgRegistrar = findViewById(R.id.imgRegistrar);
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
    }
    private void registrarPersona(){
        Intent intent = new Intent(this, Registrar.class);
        startActivity(intent);
    }
}