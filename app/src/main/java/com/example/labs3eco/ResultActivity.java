package com.example.labs3eco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView avisoResult;
    private TextView nota;
    private Button bCalcularAgain;
    private ConstraintLayout fondo4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //recibo los valores
        String color= getIntent().getExtras().getString("color");
        String username= getIntent().getExtras().getString("username");
        double respuesta= getIntent().getExtras().getDouble("respuesta");


        avisoResult=findViewById(R.id.avisoResult);
        nota=findViewById(R.id.nota);
        bCalcularAgain= findViewById(R.id.bCalcularAgain);
        fondo4=findViewById(R.id.fondo4);

        //cambio color pantalla
        if(color.equals("azul")){
            fondo4.setBackgroundColor(Color.rgb(51,134,255));
        }
        if(color.equals("blanco")){
            fondo4.setBackgroundColor(Color.rgb(255,255,255));
        }
        if(color.equals("negro")){
            fondo4.setBackgroundColor(Color.rgb(33 ,32,32));
        }

        //setText username y nota
        avisoResult.setText("Hola "+username+" tu nota es de");
        nota.setText(" " + respuesta);

        Log.e(" ", String.valueOf(respuesta));

        bCalcularAgain.setOnClickListener(this);

    }


    public void onClick (View view ){

        String color= getIntent().getExtras().getString("color");

        Intent i= new Intent(this, NameActivity.class);
        i.putExtra("color", color);
        startActivity(i);

    }
}