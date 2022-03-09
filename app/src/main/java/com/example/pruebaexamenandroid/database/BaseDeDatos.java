package com.example.pruebaexamenandroid.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.pruebaexamenandroid.database.Dao.CategoriaDao;
import com.example.pruebaexamenandroid.database.Dao.RecetaDao;
import com.example.pruebaexamenandroid.model.Categoria;
import com.example.pruebaexamenandroid.model.Receta;

@Database(entities = {Categoria.class, Receta.class}, version = 1)
public abstract class BaseDeDatos extends RoomDatabase {
    private static final String DATABASENAME = "baseDatos";

    public abstract RecetaDao recetaDao();
    public abstract CategoriaDao categoriaDao();

    private static volatile BaseDeDatos instance;

    public synchronized static BaseDeDatos getInstance(final Context contexto){
        if(instance==null){
            instance = Room.databaseBuilder(contexto.getApplicationContext(),
                    BaseDeDatos.class,DATABASENAME).allowMainThreadQueries().build();
        }
        return instance;
    }
}
