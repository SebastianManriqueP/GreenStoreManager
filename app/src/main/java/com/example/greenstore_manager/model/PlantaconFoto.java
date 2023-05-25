package com.example.greenstore_manager.model;

import java.util.List;

public class PlantaconFoto {

    private  Planta planta;

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }

    public List<String> getPlantaFotos() {
        return plantaFotos;
    }

    public void setPlantaFotos(List<String> plantaFotos) {
        this.plantaFotos = plantaFotos;
    }

    List<String> plantaFotos;


}
