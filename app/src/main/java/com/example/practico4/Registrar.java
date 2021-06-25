package com.example.practico4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registrar extends AppCompatActivity {

    private EditText editTextNombreCompleto, editTextNombreUsuario, editTextEmail, editTextContraseña2, editTextContraseña;
    private Button buttonRegistrar2, buttonIngresar2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar);

        this.cargarComponentes();
        setTitle("Bienvenido");

        buttonRegistrar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrar();
            }
        });

        buttonIngresar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingresar();
            }
        });
    }


    private void cargarComponentes(){

        editTextNombreCompleto = findViewById(R.id.editTextNombreCompleto);
        editTextNombreUsuario = findViewById(R.id.editTextUsuario);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextContraseña = findViewById(R.id.editTextContraseña);
        editTextContraseña2 = findViewById(R.id.editTextContraseña2);
        buttonIngresar2 = findViewById(R.id.buttonIngresar2);
        buttonRegistrar2 = findViewById(R.id.buttonRegistrar2);
    }

    private void registrar(){

        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("NombreCompleto", editTextNombreCompleto.getText().toString());
        editor.putString("NombreUsuario", editTextNombreUsuario.getText().toString());
        editor.putString("Email", editTextEmail.getText().toString());
        editor.putString("Contraseña2", editTextContraseña2.getText().toString());
        editor.putString("Contraseña", editTextContraseña.getText().toString());
        editor.commit();
        Toast.makeText(this, "Listo", Toast.LENGTH_SHORT).show();
    }

    private void ingresar(){

        Intent intent = new Intent(Registrar.this, MainActivity.class);
        startActivity(intent);
    }


}
