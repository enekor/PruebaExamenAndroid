package com.example.pruebaexamenandroid.ui.Recetas;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.pruebaexamenandroid.Intercambio;
import com.example.pruebaexamenandroid.databinding.FragmentHomeBinding;
import com.example.pruebaexamenandroid.ui.Recetas.nuevaReceta.NuevaReceta;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecetaAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new RecetaAdapter(getActivity(),getActivity());

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        if(Intercambio.getInstance().getReceta()!=null)
            Toast.makeText(getActivity(), "Mostrando las recetas de la categoria "+Intercambio.getInstance().getCategoria().getNombre(), Toast.LENGTH_SHORT).show();


        binding.recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recycler.setAdapter(adapter);
        onClickListener();

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

        adapter = new RecetaAdapter(getActivity(),getActivity());
        binding.recycler.setAdapter(adapter);

        Toast.makeText(getActivity(), "Mostrando las recetas de la categoria "+Intercambio.getInstance().getCategoria().getNombre(), Toast.LENGTH_SHORT).show();
    }

    private void onClickListener(){
        binding.nuevaReceta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NuevaReceta.class);
                startActivity(intent);
            }
        });
    }
}