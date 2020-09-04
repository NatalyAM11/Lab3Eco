package com.example.labs3eco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NotaActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText proyecto1Nota;
    private EditText proyecto2Nota;
    private EditText quizNota;
    private EditText parcial1Nota;
    private EditText parcial2Nota;
    private Button bCalcular;

    private double respuesta;


    private String proyecto1, proyecto2, quiz, parcial1,parcial2;
    private double proyecto1n, proyecto2n, quizn, parcial1n,parcial2n;
    private ConstraintLayout fondo3;
    private Nota nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota);

        String color=getIntent().getExtras().getString("color");


        bCalcular= findViewById(R.id.bCalcular);
        proyecto1Nota=findViewById(R.id.proyecto1Nota);
        proyecto2Nota=findViewById(R.id.proyecto2Nota);
        quizNota=findViewById(R.id.quizNota);
        parcial1Nota=findViewById(R.id.parcial1Nota);
        parcial2Nota=findViewById(R.id.parcial2Nota);
        fondo3=findViewById(R.id.fondo3);

        //intento hacer lo del cambio de pantalla

        if(color.equals("azul")){
            fondo3.setBackgroundColor(Color.rgb(51,134,255));
        }
        if(color.equals("blanco")){
            fondo3.setBackgroundColor(Color.rgb(255,255,255));
        }
        if(color.equals("negro")){
            fondo3.setBackgroundColor(Color.rgb(33 ,32,32));
        }

        bCalcular.setOnClickListener(this);


       /* String proyecto1 = proyecto1Nota.getText().toString();
        String proyecto2 = proyecto2Nota.getText().toString();
        String quiz = quizNota.getText().toString();
        String parcial1 = parcial1Nota.getText().toString();
        String parcial2 = parcial2Nota.getText().toString();*/

    }



    public void onClick (View view){

        //Tomo los valores
        String color=getIntent().getExtras().getString("color");
        String username= getIntent().getExtras().getString("username");


        //notas
        proyecto1 = proyecto1Nota.getText().toString();
        proyecto2 = proyecto2Nota.getText().toString();
        quiz = quizNota.getText().toString();
        parcial1 = parcial1Nota.getText().toString();
        parcial2 = parcial2Nota.getText().toString();


        if(proyecto1.trim().isEmpty() || proyecto2.trim().isEmpty() || quiz.trim().isEmpty() || parcial1.trim().isEmpty() || parcial2.trim().isEmpty()){
            Toast.makeText(this, " Uno de los campos no fue llenado", Toast.LENGTH_LONG).show();
            return;
            }

        //notas double
        proyecto1n = Double.parseDouble(proyecto1);
        proyecto2n = Double.parseDouble(proyecto2);
        quizn = Double.parseDouble(quiz);
        parcial1n = Double.parseDouble(parcial1);
        parcial2n = Double.parseDouble(parcial2);

        //calcular nota
        respuesta=(proyecto1n*0.25)+(proyecto2n*0.25)+(quizn*0.15)+(parcial1n*0.15)+(parcial2n*0.15);

        Intent i= new Intent(this, ResultActivity.class);
        i.putExtra("color", color);
        i.putExtra("respuesta", respuesta);
        i.putExtra("username", username);
        startActivity(i);

    }

}