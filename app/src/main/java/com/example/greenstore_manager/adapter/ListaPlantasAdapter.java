package com.example.greenstore_manager.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greenstore_manager.R;
import com.example.greenstore_manager.model.Planta;
import com.example.greenstore_manager.model.PlantaconFoto;
import com.example.greenstore_manager.ui.home.listarPlantasFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListaPlantasAdapter extends RecyclerView.Adapter<ListaPlantasAdapter.PlantaViewHolder> {

    private List<Planta> listaPlantas;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    private Context context;

    public List<Planta> getListaPlantas() {
        return listaPlantas;
    }

    public void setListaPlantas(List<Planta> listaPlantas) {
        this.listaPlantas = listaPlantas;
    }



    @NonNull
    @Override
    public PlantaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_plantas,parent,false);
        return new PlantaViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull PlantaViewHolder holder, int position) {
        Planta e = listaPlantas.get(position);
        holder.planta = e;

        /*Cambiar foto*/
        ImageView imageView = holder.itemView.findViewById(R.id.imageView3);
        Picasso.with(context)
                .load("https://images.unsplash.com/photo-1538935732373-f7a495fea3f6?ixlib=rb-4.0.3&ixid=&auto=format&fit=crop&w=1559&q=80")
                .fit()
                .centerInside()
                .into(imageView);
        /*Cambiar nombre*/
        TextView textViewFirstName = holder.itemView.findViewById(R.id.textCompra);
        textViewFirstName.setText(e.getNombreplanta());
        /*Cambiar Categoria*/
        TextView textViewCategoria = holder.itemView.findViewById(R.id.textTipo);
        textViewCategoria.setText("Categoria: " +e.getCategoria().getNombrecategoria());
        /*Cambiar Stock*/
        TextView textViewStock = holder.itemView.findViewById(R.id.textView3);
        textViewStock.setText("Stock: " +e.getStock());
        /*Cambiar Precio*/
        TextView textViewPrecio = holder.itemView.findViewById(R.id.textView4);
        textViewStock.setText("Precio: " +e.getPrecio());
    }

    @Override
    public int getItemCount() {
        return listaPlantas.size();
    }

    public void setContext(listarPlantasFragment homeFragment) {
    }

    public class PlantaViewHolder extends RecyclerView.ViewHolder{
        Planta planta;

        public PlantaViewHolder(@NonNull View itemView ){
            super(itemView);

            /*Boton Borrar*/
            ImageButton button = itemView.findViewById(R.id.imageButton2);
            button.setOnClickListener(view -> {
                String nombre = planta.getNombreplanta();
                Log.d("msg-test", "Presionando la planta: " + nombre);
            });
            /*Boton editar*/
        }
    }



}
