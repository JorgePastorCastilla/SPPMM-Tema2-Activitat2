package com.example.activitat2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Afegir extends AppCompatActivity implements View.OnClickListener{

    DBInterface bd;
    EditText editNom;
    EditText editEmail;
    Button btnAfegir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afegir);

        editNom = findViewById(R.id.editTextNomAfegir);
        editEmail = findViewById(R.id.editTextEmailAfegir);
        btnAfegir = (Button) findViewById(R.id.buttonAfegirAfegir);
        btnAfegir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnAfegir) {
            bd = new DBInterface(this);
            bd.obre();
            if (bd.insereixContacte(editNom.getText().toString(), editEmail.getText().toString()) != -1) {
                Toast.makeText(this, "Afegit correctament",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error a l’afegir",
                        Toast.LENGTH_SHORT).show();
            }
            bd.tanca();
            finish();
        }
    }
}
