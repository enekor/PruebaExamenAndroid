package com.example.pruebaexamenandroid.ui.Categorias;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.pruebaexamenandroid.databinding.FragmentGalleryBinding;
import com.example.pruebaexamenandroid.databinding.NuevaCategoriaBinding;
import com.example.pruebaexamenandroid.ui.Categorias.nuevaCategoria.NuevaCategoria;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.recycerCategoria.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recycerCategoria.setAdapter(new GaleriaAdapter(getActivity()));

        binding.nuevaCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nuevaCategoria();
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.recycerCategoria.setAdapter(new GaleriaAdapter(getActivity()));
    }

    private void nuevaCategoria(){
        NuevaCategoria nc = new NuevaCategoria(getActivity(),this);
        nc.show(getActivity().getSupportFragmentManager(),null);
    }
}