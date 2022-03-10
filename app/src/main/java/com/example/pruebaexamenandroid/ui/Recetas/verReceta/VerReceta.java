package com.example.pruebaexamenandroid.ui.Recetas.verReceta;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.pruebaexamenandroid.Intercambio;
import com.example.pruebaexamenandroid.databinding.ActivityVerRecetaBinding;
import com.example.pruebaexamenandroid.mapper.UriMapper;
import com.example.pruebaexamenandroid.model.Receta;

public class VerReceta extends AppCompatActivity {

    private ActivityVerRecetaBinding binding;
    private Receta r = Intercambio.getInstance().getReceta();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityVerRecetaBinding.inflate(getLayoutInflater());

        binding.dificultadView.setText(setDificultad());
        binding.imagenView.setImageURI(UriMapper.getInstance().fromStringToUri(r.getFoto()));
        binding.nombreView.setText(r.getNombre());
        Log.i("tiempo",""+r.getTiempoDeCoccion());
        binding.tiempoView.setText("Tiempo de preparacion: "+r.getTiempoDeCoccion()+"min");
        binding.preparacionVIew.setText(r.getElavoracion());
        binding.ingredientesView.setText(r.getIngredientes());
        setContentView(binding.getRoot());
    }

    private String setDificultad(){
        String ret = "Dificultad: ";

        if(r.getDificultad()==1){
            ret+="facil";
        }
        else if(r.getDificultad()==2){
            ret+="medio";
        }
        else{
            ret+="dificil";
        }
        return ret;
    }
}