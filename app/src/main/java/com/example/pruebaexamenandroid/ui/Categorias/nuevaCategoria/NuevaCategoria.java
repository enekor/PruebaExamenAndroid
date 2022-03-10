package com.example.pruebaexamenandroid.ui.Categorias.nuevaCategoria;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.example.pruebaexamenandroid.database.BaseDeDatos;
import com.example.pruebaexamenandroid.databinding.NuevaCategoriaBinding;
import com.example.pruebaexamenandroid.model.Categoria;
import com.example.pruebaexamenandroid.ui.Categorias.GalleryFragment;

public class NuevaCategoria extends DialogFragment {

    private NuevaCategoriaBinding binding;
    private Context context;
    private GalleryFragment fragment;

    public NuevaCategoria(Context contexto, GalleryFragment fragment){
        this.context = contexto;
        this.fragment = fragment;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = NuevaCategoriaBinding.inflate(inflater,container,false);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!binding.editTextTextPersonName.getText().toString().equalsIgnoreCase("")){
                    Categoria c = new Categoria();
                    c.setNombre(binding.editTextTextPersonName.getText().toString());
                    BaseDeDatos.getInstance(context).categoriaDao().insertCategoria(c);
                    fragment.onResume();
                    dismiss();
                }else{
                    Toast.makeText(context, "Faltan campos por rellenar", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return binding.getRoot();
    }
}
