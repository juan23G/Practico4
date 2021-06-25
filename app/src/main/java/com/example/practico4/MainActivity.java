package com.example.practico4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsuario, editTextContraseña2;
    private Button buttonIngresar, buttonRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.cargarComponentes();

        setTitle("Bienvenido");

        buttonIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingresar();
            }
        });

        buttonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrar();
            }
        });

    }

    private void cargarComponentes(){

        editTextUsuario = findViewById(R.id.editTextUsuario);
        editTextContraseña2 = findViewById(R.id.editTextContraseña2);
        buttonIngresar = findViewById(R.id.buttonIngresar);
        buttonRegistrar = findViewById(R.id.buttonRegistrar);
    }

    private void ingresar(){

        String usuario = editTextUsuario.getText().toString();
        String contraseña = editTextContraseña2.getText().toString();

        if (usuario.equals("ites") && contraseña.equals("123456")){
            sharepreference(usuario);

            Intent intent = new Intent(MainActivity.this, Detalles.class);
            intent.putExtra("EXTRA_EMAIL", usuario);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "datos incorrectos, reintente", Toast.LENGTH_SHORT).show();
        }
    }

    private void registrar(){
        Intent intent = new Intent(MainActivity.this, Registrar.class);
        startActivity(intent);
    }

    private void sharepreference(String usuario){

        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("usuario", usuario);
        editor.commit();
    }

}