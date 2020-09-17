package com.example.labs3eco;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static android.graphics.Color.rgb;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bBlue;
    private Button bWhite;
    private Button bBlack;
    private ConstraintLayout fondo;
    private String color;

    private int colorsito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bBlue= findViewById(R.id.bBlue);
        bWhite= findViewById(R.id.bWhite);
        bBlack= findViewById(R.id.bBlack);
        fondo= findViewById(R.id.fondo);




        bBlue.setOnClickListener(this);
        bWhite.setOnClickListener(this);
        bBlack.setOnClickListener(this);


    }



                public void onClick (View view){

                    //Cambio de pantalla


                    switch (view.getId()){
                        case R.id.bBlue:
                        fondo.setBackgroundColor(Color.rgb(51,134,255));
                        color="azul";
                        break;

                        case R.id.bWhite:
                            fondo.setBackgroundColor(Color.rgb (255,255,255));
                            color="blanco";
                            break;

                        case R.id.bBlack:
                            fondo.setBackgroundColor(Color.rgb (33 ,32,32));
                            color="negro";
                            break;
                    }

                    Intent i= new Intent(this, NameActivity.class);
                    i.putExtra("color", color);
                    startActivityForResult(i,10);

                }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences=getSharedPreferences("locker",MODE_PRIVATE);
        preferences.edit().putString("color",color).apply();

    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode==10 && resultCode==RESULT_OK) {
             color = data.getExtras().getString("color");
        }
    }
}






