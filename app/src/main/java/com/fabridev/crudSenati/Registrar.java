package com.fabridev.crudSenati;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.fabridev.crudSenati.Utilidades.ConexionSQL;
import com.fabridev.crudSenati.Utilidades.DateTime;

import org.w3c.dom.Text;

public class Registrar extends AppCompatActivity {
    EditText txtNombre, txtApellidos, numberTelefono, txtEmail, txtusuario;
    ImageView retroceder;
    Button btnregistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        loadUI();

        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preguntar();
            }
        });
    }

    private void loadUI(){
        txtNombre = findViewById(R.id.txtNombre);
        txtApellidos = findViewById(R.id.txtApellidos);
        numberTelefono = findViewById(R.id.numberTelefono);
        txtEmail = findViewById(R.id.txtEmail);
        txtusuario = findViewById(R.id.txtusuario);
        btnregistrar = findViewById(R.id.btnregistrar);
    }
    private void resetUI(){
        txtusuario.setText(null);
        txtNombre.setText(null);
        txtApellidos.setText(null);
        numberTelefono.setText(null);
        txtEmail.setText(null);
    }
    private void registrar(){
        //Instanciamos nuestra clase conexion
        ConexionSQL conexion = new ConexionSQL(this, "crudPersonas", null, 1);
        //permisos (lectura - escritura)
        SQLiteDatabase db = conexion.getWritableDatabase();
        //preparar los valores enviados (key > value)
        ContentValues parametros = new ContentValues();
        if(txtusuario.getText().toString().equalsIgnoreCase("") ||
                txtNombre.getText().toString().equalsIgnoreCase("") ||
                txtApellidos.getText().toString().equalsIgnoreCase("") ||
                numberTelefono.getText().toString().equalsIgnoreCase("")
        ){
            Toast.makeText(this, "debe Completar el formulario", Toast.LENGTH_SHORT).show();
        } else {
            parametros.put("nombre", txtNombre.getText().toString());
            parametros.put("apellidos", txtApellidos.getText().toString());
            parametros.put("telefono", numberTelefono.getText().toString());
            parametros.put("correo", txtEmail.getText().toString());
            parametros.put("nombreUsuario", txtusuario.getText().toString());
            parametros.put("create_at", DateTime.getDateTimeFormat("yyyy-MM-dd"));
            long idpersonas = db.insert("personas","nombreUsuario", parametros);
            resetUI();
            //mensaje confirmacion
            Toast.makeText(this, "proceso terminado Correctamente - ID " + (idpersonas), Toast.LENGTH_SHORT).show();
        }
    }

    private void preguntar(){
        AlertDialog.Builder pregunta = new AlertDialog.Builder(this);
        pregunta.setTitle("CRUD SENATI - FABRIDEV")
                .setIcon(R.mipmap.notificacion)
                .setMessage("¿Estas Seguro de Agregar Al Usuario?")
                .setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        registrar();
                    }
                });
        pregunta.show();
    }
}