package com.example.labs3eco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NameActivity extends AppCompatActivity implements View.OnClickListener {


    private Button bConfgMain2;
    private EditText userName;
    private Button bContinuar;
    private ConstraintLayout fondo2;

    private String username;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String color= getIntent().getExtras().getString("color");


        bConfgMain2= findViewById(R.id.bConfgMain2);
        userName= findViewById(R.id.userName);
        bContinuar= findViewById(R.id.bContinuar);
        fondo2= findViewById(R.id.fondo2);


        //intento hacer lo del cambio de pantalla

        if(color=="azul"){
            fondo2.setBackgroundColor(Color.rgb(51,134,255));
        }
        if(color=="blanco"){
            fondo2.setBackgroundColor(Color.rgb(255,255,255));
        }
        if(color=="negro"){
            fondo2.setBackgroundColor(Color.rgb(33 ,32,32));
        }

        bConfgMain2.setOnClickListener(this);
        bContinuar.setOnClickListener(this);

    /*      bConfgMain2.setOnClickListener(
                (v)->{
                    Intent i= new Intent();
                    finish();
                }
        );

        bContinuar.setOnClickListener(
                (v)->{
                    Intent a = new Intent(this, NotaActivity.class);
                    startActivity(a);

                }
        );*/



    }


    @Override
    public void onClick(View view) {

        username= userName.getText().toString();

        switch (view.getId()){

            case R.id.bConfgMain2:
                finish();
                break;

            case R.id.bContinuar:
                Intent a = new Intent(this, NotaActivity.class);
                startActivity(a);
                a.putExtra("username", username);
                break;

        }
    }
}