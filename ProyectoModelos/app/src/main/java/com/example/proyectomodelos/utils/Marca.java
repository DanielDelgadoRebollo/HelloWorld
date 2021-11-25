package com.example.proyectomodelos.utils;

public class Marca {

    private String marca;
    private int imagen;

    public Marca(String marca,int imagen){
        this.marca = marca;
        this.imagen = imagen;
    }

    public Marca(){

    }
    public Marca(String marca){
        this.marca=marca;
    }

    public String getMarca() {
        return marca;
    }

    public int getImagen() {
        return imagen;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
