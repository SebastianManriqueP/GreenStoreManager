package com.example.greenstore_manager.model;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GreenStoreRepository {

    @GET("/webServiceGS/plantas/lista")
    Call<List<Planta>> getListaPlantas();

    @GET("/webServiceGS/plantas/listaConFotos")
    Call<ListaPlanta>getListaPlantasFotos();

    @GET("/webServiceGS/compraS/listaCompras")
    Call<List<ListaCompra>>getListaComprass();

    @GET("/webServiceGS/personas/listar")
    Call<List<Persona>>getListaPersonas();

}
