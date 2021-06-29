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

    private EditText editTextNombreCompleto, editTextNombreUsuario, editTextEmail, editTextContraseaa, editTextContrasea;
    private Button buttonRegistrarSegundo, buttonIngresar2;
    private String usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar);

        this.cargarComponentes();

        Intent intent = getIntent();
        usuario = intent.getStringExtra("EXTRA_EMAIL");



        setTitle("Bienvenido");

        buttonRegistrarSegundo.setOnClickListener(new View.OnClickListener() {
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
        editTextContrasea = findViewById(R.id.editTextContrasea);
        editTextContraseaa = findViewById(R.id.editTextContraseaa);
        buttonIngresar2 = findViewById(R.id.buttonIngresar2);
        buttonRegistrarSegundo = findViewById(R.id.buttonRegistrarSegundo);
    }

    private void registrar(){

        String nombre = editTextNombreCompleto.getText().toString();
        String usuarioo = editTextNombreUsuario.getText().toString();
        String email = editTextEmail.getText().toString();
        String contrasea = editTextContrasea.getText().toString();
        String contraseaa = editTextContraseaa.getText().toString();

        if (!nombre.equals("") && !usuarioo.equals("") && !email.equals("") && !contrasea.equals("") && !contraseaa.equals(""))
        //if(!nombre.isEmpty() && !usuario.isEmpty() && !email.isEmpty() && !contraseña.isEmpty() && !contraseña.isEmpty())
        {
            sharepreference(nombre, usuarioo, email, contrasea, contraseaa);
            /*spUsuario(usuarioo);
            spNombre(nombre);
            spEmail(email);
            spContrasea(contrasea);
            spContraseaa(contraseaa);*/

            Intent intent = new Intent(Registrar.this, Detalles.class);
            intent.putExtra("EXTRA_EMAIL", usuarioo);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Completar todos los campos", Toast.LENGTH_SHORT).show();
        }
        /*editor.putString("NombreCompleto", editTextNombreCompleto.getText().toString());
        editor.putString("NombreUsuario", editTextNombreUsuario.getText().toString());
        editor.putString("Email", editTextEmail.getText().toString());
        editor.putString("Contraseña2", editTextContraseña2.getText().toString());
        editor.putString("Contraseña", editTextContraseña.getText().toString());
        editor.commit();*/

    }

    private void ingresar(){

        Intent intent = new Intent(Registrar.this, MainActivity.class);
        startActivity(intent);
    }
    private void sharepreference(String nombre, String usuarioo, String email, String contrasea, String contraseaa){


        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("usuario", usuarioo);
        editor.putString("nombre", nombre);
        editor.putString("email", email);
        editor.putString("contrasea", contrasea);
        editor.putString("contraseaa", contraseaa);
        editor.commit();
    }
    /*private void spUsuario(String usuarioo){
        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("usuario", usuarioo);
        editor.commit();
    }
    private void spNombre(String nombre){
        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("nombre", nombre);
        editor.commit();
    }
    private void spEmail(String email){
        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("email", email);
        editor.commit();
    }
    private void spContrasea(String contrasea){
        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("contrasea", contrasea);
        editor.commit();
    }
    private void spContraseaa(String contraseaa){
        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("contraseaa", contraseaa);
        editor.commit();
    }*/

}
