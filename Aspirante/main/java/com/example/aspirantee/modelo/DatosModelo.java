package com.example.aspirantee.modelo;

public class DatosModelo {

    public int promedio;
    public String tipoBachillerato;

   // public String getTipoBachillerato() {
     //   return tipoBachillerato;
    //}

    public void setTipoBachillerato(String tipoBachillerato) {
        this.tipoBachillerato = tipoBachillerato;
    }

    //public int getPromedio() {
        //return promedio;
    //}

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }

    //Operaciones
    public String Registro(){
        String resultado = null;
        switch (tipoBachillerato) {
            case "Fisico-Matematico":
                if (promedio>80) {
                    resultado= "Felicidades Aspirante seleccionado con promedio de: ";
                }else{
                    resultado="Aspirante rechazado con promedio de: ";
                }
                break;
            case "Quimico-Biologicas":
                if (promedio > 90) {
                    resultado = "Felicidades aspirante seleccionado con promedio de: ";
                }else{
                    resultado="Aspirante rechazado con promedio de: ";
                }
                break;
            case "Humanidaddes y Artes":
                if (promedio > 90) {
                    resultado = "Felicidades aspirante seleccionado con promedio de: ";
                }else{
                    resultado="Aspirante rechazado con promedio de: ";
                }
                break;
            case "Economico-Administrativo":
                if (promedio > 90) {
                    resultado = "Felicidades aspirante seleccionado con promedio de: ";
                }else{
                    resultado="Aspirante rechazado con promedio de: ";
                }
                break;
        }
        return resultado + "" + promedio;
    }
}
