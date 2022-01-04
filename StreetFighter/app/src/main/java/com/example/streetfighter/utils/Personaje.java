package com.example.streetfighter.utils;

public class Personaje {
    private String nombre,poder,nacionalidad;
    private int imagen,escenario,imagenPerder;

    public Personaje(){

    }

    public Personaje(int imagen,String nombre,String poder,String nacionalidad,int escenario,int imagenPerder){
        this.nombre=nombre;
        this.imagen=imagen;
        this.escenario=escenario;
        this.imagenPerder=imagenPerder;
        this.poder = poder;
        this.nacionalidad=nacionalidad;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getEscenario() {
        return escenario;
    }

    public void setEscenario(int escenario) {
        this.escenario = escenario;
    }

    public int getImagenPerder() {
        return imagenPerder;
    }

    public void setImagenPerder(int imagenPerder) {
        this.imagenPerder = imagenPerder;
    }
}
