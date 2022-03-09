package com.example.pruebaexamenandroid.ui.Recetas;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.pruebaexamenandroid.databinding.FragmentHomeBinding;
import com.example.pruebaexamenandroid.ui.Recetas.nuevaReceta.NuevaReceta;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recycler.setAdapter(new RecetaAdapter(getActivity()));
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
        binding.recycler.setAdapter(new RecetaAdapter(getActivity()));
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