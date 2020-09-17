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


        //intento hacer lo del cambio de color de la pantalla

       if(color.equals("azul")){
            fondo2.setBackgroundColor(Color.rgb(51,134,255));
        }
        if(color.equals("blanco")){
            fondo2.setBackgroundColor(Color.rgb(255,255,255));
        }
        if(color.equals("negro")){
            fondo2.setBackgroundColor(Color.rgb(33 ,32,32));
        }

        bConfgMain2.setOnClickListener(this);
        bContinuar.setOnClickListener(this);



    }


    @Override
    public void onClick(View view) {

        String color= getIntent().getExtras().getString("color");

        switch (view.getId()){

            case R.id.bConfgMain2:

                color= getSharedPreferences("na", MODE_PRIVATE).getString("color", "NO_USER");

                Intent i = new Intent(this, MainActivity.class);
                i.putExtra("color", color);
                setResult(RESULT_OK, i);
                startActivity(i);
                break;

            case R.id.bContinuar:

                //get username
                username= userName.getText().toString();

                if(username.trim().isEmpty()){
                    Toast.makeText(this, " Uno de los campos no fue llenado", Toast.LENGTH_LONG).show();
                    return;
                }

                Intent a = new Intent(this, NotaActivity.class);
                a.putExtra("color", color);
                a.putExtra("username", username);
                startActivity(a);
                break;

        }

    }

}