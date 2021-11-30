package com.example.examenprimeraevaluacion.utils;

public class Elementos {
    String nombre,tipo,categoria;
    int imagen;


    public Elementos(String nombre,String tipo,int imagen,String categoria){
        this.nombre=nombre;
        this.tipo = tipo;
        this.imagen = imagen;
        this.categoria=categoria;

    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
