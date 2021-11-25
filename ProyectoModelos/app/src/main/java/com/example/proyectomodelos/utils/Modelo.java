package com.example.proyectomodelos.utils;

public class Modelo {
    private String modelo;
    private int cv,imagen;
    private Marca marca;

    public Modelo(){

    }

    public Modelo(Marca marca,String modelo,int cv,int imagen){
        this.marca = marca;
        this.modelo = modelo;
        this.cv = cv;
        this.imagen = imagen;
    }

    public int getImagen() {
        return imagen;
    }

    public int getCv() {
        return cv;
    }

    public String getModelo() {
        return modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
