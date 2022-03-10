package com.example.pruebaexamenandroid.ui.Recetas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pruebaexamenandroid.Intercambio;
import com.example.pruebaexamenandroid.R;
import com.example.pruebaexamenandroid.database.BaseDeDatos;
import com.example.pruebaexamenandroid.mapper.UriMapper;
import com.example.pruebaexamenandroid.model.Receta;
import com.example.pruebaexamenandroid.ui.Recetas.verReceta.VerReceta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RecetaAdapter extends RecyclerView.Adapter<RecetaAdapter.ViewHolder> {

    List<Receta> recetas = new ArrayList<>();
    Context context;

    public RecetaAdapter(Context context, Activity activity){

        if(Intercambio.getInstance().getCategoria()==null){
            activity.onBackPressed();
            Toast.makeText(activity, "seleccione una en la pantalla de categorias", Toast.LENGTH_SHORT).show();
        }

        if(Intercambio.getInstance().getCategoria()!=null) {
            recetas = BaseDeDatos.getInstance(context).recetaDao().selectByCategoria(Intercambio.getInstance().getCategoria().getNombre());
        }

        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public RecetaAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.receta_preview,parent,false);
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
        ConstraintLayout layout;
        public ViewHolder(@NonNull @NotNull View v) {
            super(v);
            imagen = v.findViewById(R.id.recetaImagen);
            nombre = v.findViewById(R.id.nombreReceta);
            dificultad = v.findViewById(R.id.dificultadReceta);
            layout = v.findViewById(R.id.layoutPreview);

            onClick();
        }

        private void onClick(){
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int posicion = getAdapterPosition();
                    Intercambio.getInstance().setReceta(recetas.get(posicion));
                    context.startActivity(new Intent(context,VerReceta.class));
                }
            });
        }
    }


}
