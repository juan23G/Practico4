package com.example.practico4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Detalles extends AppCompatActivity {

    private Button buttonLlamar, buttonContactar, buttonGIT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalles);

        this.cargarComponentes();
        setTitle ( " Acerca de " );

        buttonLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telefono();
            }
        });

        buttonGIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GIT();
            }
        });

        buttonContactar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contactar();
            }
        });

    }

    private void cargarComponentes(){

        buttonLlamar = findViewById(R.id.buttonLlamar);
        buttonContactar = findViewById(R.id.buttonContactar);
        buttonGIT= findViewById(R.id.buttonGIT);
    }

    private void telefono(){

        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel://2954 633659"));
        startActivity(intent);
    }

    private void Contactar(){

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, "cazauxjuanmarcelo@gmail.com");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Consulta");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "cazauxjuanmarcelo@gmail.com");
        startActivity(Intent.createChooser(emailIntent,"Send Email"));

        /*String[] TO = {""}; //Direcciones email  a enviar.
        String[] CC = {""}; //Direcciones email con copia.

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Tu Asunto...");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "tuemail@email.com"); // * configurar email aquí!

        try {
            startActivity(Intent.createChooser(emailIntent, "Enviar email."));
            Log.i("EMAIL", "Enviando email...");
        }
        catch (android.content.ActivityNotFoundException e) {
            Toast.makeText(this, "NO existe ningún cliente de email instalado!.", Toast.LENGTH_SHORT).show();
        }*/

    }

    private void GIT(){

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/juan23G"));
        startActivity(intent);

    }


}

