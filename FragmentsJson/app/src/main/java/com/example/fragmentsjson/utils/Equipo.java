package com.example.fragmentsjson.utils;

public class Equipo {
    String imagen,textoNombre,textoEstadio,id;

    public Equipo(String imagen, String textoNombre, String textoEstadio,String id) {
        this.imagen = imagen;
        this.textoNombre = textoNombre;
        this.textoEstadio = textoEstadio;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTextoNombre() {
        return textoNombre;
    }

    public void setTextoNombre(String textoNombre) {
        this.textoNombre = textoNombre;
    }

    public String getTextoEstadio() {
        return textoEstadio;
    }

    public void setTextoEstadio(String textoEstadio) {
        this.textoEstadio = textoEstadio;
    }
}
