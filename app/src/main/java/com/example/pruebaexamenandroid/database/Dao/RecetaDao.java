package com.example.pruebaexamenandroid.database.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.pruebaexamenandroid.model.Receta;

import java.util.List;

@Dao
public interface RecetaDao {

    @Insert
    void insertReceta(Receta receta);

    @Query("select * from receta")
    List<Receta> getAllRecetas();

    @Query("select * from receta where categoria=:categoria")
    List<Receta> selectByCategoria(String categoria);
}

