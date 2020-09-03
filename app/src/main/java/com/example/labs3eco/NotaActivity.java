package com.example.labs3eco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NotaActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText proyecto1Nota;
    private EditText proyecto2Nota;
    private EditText quizNota;
    private EditText parcial1Nota;
    private EditText parcial2Nota;
    private Button bCalcular;

    private double respuesta;

    private double proyecto1, proyecto2, quiz, parcial1,parcial2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota);

        bCalcular= findViewById(R.id.bCalcular);

        bCalcular.setOnClickListener(this);

       /* proyecto1 = Integer.parseInt(proyecto1Nota.getText().toString());
        proyecto2 = Integer.parseInt(proyecto2Nota.getText().toString());
        quiz = Integer.parseInt(quizNota.getText().toString());
        parcial1 = Integer.parseInt(parcial1Nota.getText().toString());
        parcial2 = Integer.parseInt(parcial2Nota.getText().toString());*/

        /*String proyecto1 = proyecto1Nota.getText().toString();
        String proyecto2 = proyecto2Nota.getText().toString();
        String quiz = quizNota.getText().toString();
        String parcial1 = parcial1Nota.getText().toString();
        String parcial2 = parcial2Nota.getText().toString();*/



    }



    public void onClick (View view){

        //calcular nota
        respuesta=(proyecto1*0.25)+(proyecto2*0.25)+(quiz*0.15)+(parcial1*0.15)+(parcial2*0.15);

        Intent i= new Intent(this, ResultActivity.class);
        startActivity(i);

    }
}