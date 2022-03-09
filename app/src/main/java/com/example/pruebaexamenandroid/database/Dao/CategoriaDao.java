package com.example.pruebaexamenandroid.database.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.pruebaexamenandroid.model.Categoria;

import java.util.List;

@Dao
public interface CategoriaDao {

    @Insert
    void insertCategoria(Categoria categoria);

    @Query("select * from categoria")
    List<Categoria> getAllCategorias();

    @Query("select * from categoria where nombre=:nombre")
    Categoria getByNombre(String nombre);

}
