package com.example.pruebaexamenandroid.ui.Categorias;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
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
import com.example.pruebaexamenandroid.model.Categoria;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GaleriaAdapter extends RecyclerView.Adapter<GaleriaAdapter.ViewHolder>{
    List<Categoria> categorias;
    Context context;

    public GaleriaAdapter(Context context) {
        this.categorias = BaseDeDatos.getInstance(context).categoriaDao().getAllCategorias();
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public GaleriaAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.categoria_preview,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull GaleriaAdapter.ViewHolder holder, int i) {
        holder.nombre.setText(categorias.get(i).getNombre());
    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout layout;
        TextView nombre;
        ImageView imagen;

        public ViewHolder(@NonNull @NotNull View v) {
            super(v);
            layout = v.findViewById(R.id.layoutCategoria);
            nombre = v.findViewById(R.id.tituloCategoria);
            imagen = v.findViewById(R.id.imagenCategoria);

            onClick();
        }

        private void onClick(){
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intercambio.getInstance().setCategoria(categorias.get(getAdapterPosition()));
                    Toast.makeText(context, "Categoria "+categorias.get(getAdapterPosition()).getNombre()+" seleccionada", Toast.LENGTH_SHORT).show();
                    layout.setBackgroundColor(Color.GRAY);
                }
            });
        }
    }
}
