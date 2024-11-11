package com.example.traductor.javaModelo;

public class Idioma {

    String codigoIdioma;
    String tituloIdioma;

    public Idioma(String codigoIdioma, String tituloIdioma) {
        this.codigoIdioma = codigoIdioma;
        this.tituloIdioma = tituloIdioma;
    }

    public String getCodigoIdioma() {
        return codigoIdioma;
    }

    public void setCodigoIdioma(String codigoIdioma) {
        this.codigoIdioma = codigoIdioma;
    }

    public String getTituloIdioma() {
        return tituloIdioma;
    }

    public void setTituloIdioma(String tituloIdioma) {
        this.tituloIdioma = tituloIdioma;
    }
}
