package com.fabridev.crudSenati;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.fabridev.crudSenati.Utilidades.ConexionSQL;

public class Buscar extends AppCompatActivity {
    Button btnBuscar, btnReiniciar;
    EditText cajabuscar, nombre, apellidos, telefono, correo, usuario;
    ConexionSQL conexion; //objeto conexion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        loadUI();
        conexion = new ConexionSQL(this, "crudPersonas", null, 1);
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscarPersona();
            }
        });
        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetUI();
                cajabuscar.requestFocus();
            }
        });
    }
    private void loadUI(){
        btnBuscar = findViewById(R.id.btnBuscar);
        cajabuscar = findViewById(R.id.cajabuscar);
        btnReiniciar = findViewById(R.id.btnReiniciar);
        //cajas para editar
        usuario = findViewById(R.id.usuario);
        nombre = findViewById(R.id.nombre);
        apellidos = findViewById(R.id.apellidos);
        telefono = findViewById(R.id.telefono);
        correo = findViewById(R.id.correo);
    }
    private void resetUI(){
        usuario.setText(null);
        nombre.setText(null);
        apellidos.setText(null);
        telefono.setText(null);
        correo.setText(null);
    }
    private void buscarPersona(){
        //permisos
        SQLiteDatabase db = conexion.getReadableDatabase();
        //campos utilizando como filtro
        String[] campoFiltro = {
                cajabuscar.getText().toString()
        };
        //campos que vamos a obtene (consulta)
        String[] campos = {
                "nombre",
                "apellidos",
                "telefono",
                "correo",
                "nombreUsuario"
        };
        //manejador de excepciones(en ocaciones no encontramos datos)
        try{
            //ejecutar - almacenar
            Cursor cursor = db.query("personas", campos, "idpersonas=?", campoFiltro, null, null, null);
            cursor.moveToFirst();
            //enviamos resultado a las cajas de texto
            nombre.setText(cursor.getString(0));
            apellidos.setText(cursor.getString(1));
            telefono.setText(cursor.getString(2));
            correo.setText(cursor.getString(3));
            usuario.setText(cursor.getString(3));
            cursor.close();
        }
        catch (Exception e){
            resetUI();
            Toast.makeText(this, "No existe el Usuario", Toast.LENGTH_SHORT).show();
        }
    }
}