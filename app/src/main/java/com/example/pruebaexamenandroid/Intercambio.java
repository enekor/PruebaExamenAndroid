package com.example.pruebaexamenandroid;

import com.example.pruebaexamenandroid.model.Categoria;
import com.example.pruebaexamenandroid.model.Receta;

public class Intercambio {

    private static Intercambio intercambio;
    private  Intercambio(){}

    public static Intercambio getInstance(){
        if(intercambio == null)
            intercambio = new Intercambio();
        return intercambio;
    }

    private Receta receta = null;
    private Categoria categoria = null;

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
