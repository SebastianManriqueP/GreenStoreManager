package com.example.greenstore_manager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greenstore_manager.R;
import com.example.greenstore_manager.model.Compra;
import com.example.greenstore_manager.model.ListaCompra;
import com.example.greenstore_manager.model.Planta;

import java.util.List;

public class ListaComprasAdapter extends RecyclerView.Adapter<ListaComprasAdapter.CompraViewHolder> {

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<ListaCompra> getListacompras() {
        return listacompras;
    }

    public void setListacompras(List<ListaCompra> listacompras) {
        this.listacompras = listacompras;
    }

    private List<ListaCompra> listacompras;
    private Context context;


    @NonNull
    @Override
    public CompraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_compras,parent,false);
        return new CompraViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaComprasAdapter.CompraViewHolder holder, int position) {
        ListaCompra e = listacompras.get(position);
        holder.compra = e;

        //*Cambiar nombre cliente*//
        TextView textViewFirstName = holder.itemView.findViewById(R.id.textView3);
        textViewFirstName.setText("Cliente: "+e.getCompra().getIdCliente().getNombres()+" "+e.getCompra().getIdCliente().getApellidos());
        //*Cambiar total*//
        TextView textViewTotal = holder.itemView.findViewById(R.id.textView4);
        textViewTotal.setText("Total: S/."+e.getCompra().getTotal());
        //*Cambiar Estado*//
        TextView textViewEstado = holder.itemView.findViewById(R.id.textView2);
        if(e.getCompra().getEstado().equals("V")) {
            textViewEstado.setText("Estado: Por verificar" );
        }else{
            textViewEstado.setText("Estado: En delivery" );
        }
    }


    @Override
    public int getItemCount() {
        return listacompras.size();
    }

    public static class CompraViewHolder extends RecyclerView.ViewHolder {
        ListaCompra compra;

        public CompraViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }



}
