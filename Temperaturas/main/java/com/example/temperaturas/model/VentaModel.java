package com.example.temperaturas.model;

public class VentaModel {

    private String tipoTemperatura;
    private byte temperatura;

    public String getTipoTemperatura(){ return tipoTemperatura;}

    public void setTipoTemperatura(String tipoTemperatura) {
        this.tipoTemperatura = tipoTemperatura;
    }
    public void setTemperatura(byte temperatura){this.temperatura=temperatura;}

    public String calcularVenta(){
        double c=0;
        double f=0;
        double k=0;
        double r=0;

        switch (tipoTemperatura){
            case "Celsius":
                f=(temperatura * 1.8) + 32;
                k=(temperatura + 273);
                r=(temperatura * 1.8) + 273;
                break;
            case "Fahrenheit":
                c=(temperatura -32)/1.8;
                k=(temperatura -32)/1.8 + 273;
                r=(temperatura -32) + 491;
                break;
            case "Kelvin":
                c=(temperatura - 273);
                f=1.8 * (temperatura - 273)+ 32;
                r=(temperatura - 273) * 1.8 + 491;
                break;
            case "Rankine":
                c=(temperatura - 491)/1.8;
                f=(temperatura - 491) + 32;
                k=(temperatura -491)/1.8 +273;
                break;


        }

        return "La conversion de la temperatura es \n" +
                "Celsius: " + c + "\n" +
                "Fahrenheit: " + f + "\n" +
                "Kelvin: " + k + "\n" +
                "Rankine: " + r ;
    }
}
