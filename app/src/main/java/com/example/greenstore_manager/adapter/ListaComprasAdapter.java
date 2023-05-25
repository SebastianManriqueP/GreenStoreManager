package com.example.greenstore_manager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greenstore_manager.R;
import com.example.greenstore_manager.model.Planta;

import java.util.List;

public class ListaComprasAdapter extends RecyclerView.Adapter<ListaComprasAdapter.PlantaViewHolder> {

    public List<Planta> getListaPlantas() {
        return listaPlantas;
    }

    public void setListaPlantas(List<Planta> listaPlantas) {
        this.listaPlantas = listaPlantas;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    private List<Planta> listaPlantas;
    private Context context;


    @NonNull
    @Override
    public ListaComprasAdapter.PlantaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_compras,parent,false);
        return new PlantaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaComprasAdapter.PlantaViewHolder holder, int position) {
        Planta e = listaPlantas.get(position);
        holder.planta = e;

        TextView textViewFirstName = holder.itemView.findViewById(R.id.textCompra);
        textViewFirstName.setText(e.getNombreplanta());
    }

    @Override
    public int getItemCount() {
        return listaPlantas.size();
    }

    public class PlantaViewHolder extends RecyclerView.ViewHolder {
        Planta planta;

        public PlantaViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }



}
