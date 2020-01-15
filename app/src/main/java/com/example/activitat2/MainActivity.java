package com.example.activitat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button afegirBtn = findViewById(R.id.afegirBtn);
        afegirBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                afegir();
            }
        });

        Button consultaBtn = findViewById(R.id.consultaBtn);
        consultaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                afegir();
            }
        });

        Button llistaBtn = findViewById(R.id.llistaBtn);
        llistaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llista();
            }
        });

        Button actualitzaBtn = findViewById(R.id.actualitzaBtn);
        actualitzaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualitza();
            }
        });

        Button esborraBtn = findViewById(R.id.esborraBtn);
        esborraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                esborra();
            }
        });
    }

    public void afegir(){
        Intent i = new Intent(this.getApplicationContext(), Afegir.class);
        startActivityForResult(i, codigo);
        startActivity(i);
    }
    public void consulta(){

    }
    public void llista(){

    }
    public void actualitza(){

    }
    public void esborra(){

    }
}
