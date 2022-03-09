package com.example.pruebaexamenandroid.ui.Recetas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pruebaexamenandroid.R;
import com.example.pruebaexamenandroid.database.BaseDeDatos;
import com.example.pruebaexamenandroid.mapper.UriMapper;
import com.example.pruebaexamenandroid.model.Receta;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RecetaAdapter extends RecyclerView.Adapter<RecetaAdapter.ViewHolder> {

    List<Receta> recetas;
    public RecetaAdapter(Context context){
        recetas = BaseDeDatos.getInstance(context).recetaDao().getAllRecetas();
    }

    @NonNull
    @NotNull
    @Override
    public RecetaAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.receta_preview,parent);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecetaAdapter.ViewHolder holder, int i) {
        holder.dificultad.setText("Dificultad nivel: "+recetas.get(i).getDificultad());
        holder.imagen.setImageURI(UriMapper.getInstance().fromStringToUri(recetas.get(i).getFoto()));
        holder.nombre.setText(recetas.get(i).getNombre());
    }

    @Override
    public int getItemCount() {
        return recetas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imagen;
        TextView nombre,dificultad;
        public ViewHolder(@NonNull @NotNull View v) {
            super(v);
            imagen = v.findViewById(R.id.recetaImagen);
            nombre = v.findViewById(R.id.nombreReceta);
            dificultad = v.findViewById(R.id.dificultadReceta);
        }
    }
}
