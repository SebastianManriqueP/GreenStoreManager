package com.example.greenstore_manager.model;


import java.io.Serializable;


public class Planta {
    private int idplanta;

    private String nombreplanta;

    private int stock;

    private double precio;

    private String ambienteRec;

    private Integer plantaactiva;

    private String descripcion;

    private Categoria categoria;

    public int getIdplanta() {
        return idplanta;
    }

    public void setIdplanta(int idplanta) {
        this.idplanta = idplanta;
    }

    public String getNombreplanta() {
        return nombreplanta;
    }

    public void setNombreplanta(String nombreplanta) {
        this.nombreplanta = nombreplanta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getAmbienteRec() {
        return ambienteRec;
    }

    public void setAmbienteRec(String ambienteRec) {
        this.ambienteRec = ambienteRec;
    }

    public Integer getPlantaactiva() {
        return plantaactiva;
    }

    public void setPlantaactiva(Integer plantaactiva) {
        this.plantaactiva = plantaactiva;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
