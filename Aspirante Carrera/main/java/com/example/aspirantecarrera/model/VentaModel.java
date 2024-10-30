package com.example.aspirantecarrera.model;

public class VentaModel {
    private String tipoBachiller;
    private byte promedio;
    private String nombre;

    public String getTipoBachiller(){return tipoBachiller;}

    public void setTipoBachiller(String tipoBachiller){this.tipoBachiller = tipoBachiller;}

    public void setPromedio(byte promedio){this.promedio=promedio;}

    public String getNombre(){return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String aspiranteInge(){
        if(promedio>=90 || (promedio>=80 && promedio<=90 && tipoBachiller.equalsIgnoreCase("Fisico-Matematico"))){
            return nombre + "\n" + "Fuiste seleccionado \n Eres estudiante de la Universidad";
        }else{
            return nombre + "\n" + "No fuiste seleccinado en la Universidad";
        }

    }



}
