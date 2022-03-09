package com.example.pruebaexamenandroid.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Categoria {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String nombre;
    private String foto;

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

    @Override
    public String toString() {
        return this.nombre;
    }
}

