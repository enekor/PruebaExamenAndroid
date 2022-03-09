package com.example.pruebaexamenandroid.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Receta {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String nombre;
    private String foto;
    private String tiempoDeCoccion;
    private int dificultad;
    private String categoria;
    private String ingredientes;
    private String elavoracion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTiempoDeCoccion() {
        return tiempoDeCoccion;
    }

    public void setTiempoDeCoccion(String tiempoDeCoccion) {
        this.tiempoDeCoccion = tiempoDeCoccion;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getElavoracion() {
        return elavoracion;
    }

    public void setElavoracion(String elavoracion) {
        this.elavoracion = elavoracion;
    }
}

