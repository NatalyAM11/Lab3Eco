package com.example.labs3eco;

public class Nota {

    private double nota1,nota2,nota3,nota4,nota5;
    private double respuesta;

    public Nota(int nota1,int nota2,int nota3,int nota4,int nota5){

        this.nota1=nota1;
        this.nota2=nota2;
        this.nota3=nota3;
        this.nota4=nota4;
        this.nota5=nota5;

    }

    public void calcular(){

        //calcular nota
        respuesta=(nota1*0.25)+(nota2*0.25)+(nota3*0.15)+(nota4*0.15)+(nota5*0.15);

    }
}
