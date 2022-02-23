package com.example.proyectofinalandroid.utils;

public class Equipo {
    private String imagen,nombreEquipo;

    public Equipo(String imagen,String nombreEquipo){
        this.imagen = imagen;
        this.nombreEquipo = nombreEquipo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
}
