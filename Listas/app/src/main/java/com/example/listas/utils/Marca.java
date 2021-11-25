package com.example.listas.utils;

public class Marca {
    private String nombre,color,modelo;
    int imagen,cv,cc;

    public Marca(String nombre,int imagen,String color,String modelo,int cv, int cc){
        this.nombre = nombre;
        this.imagen = imagen;
        this.color = color;
        this.modelo = modelo;
        this.cv = cv;
        this.cc = cc;
    }

    public int getCc() {
        return cc;
    }

    public int getCv() {
        return cv;
    }

    public String getColor() {
        return color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public String getNombre() {
        return nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

