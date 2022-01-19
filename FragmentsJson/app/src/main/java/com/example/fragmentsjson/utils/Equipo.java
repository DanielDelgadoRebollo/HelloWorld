package com.example.fragmentsjson.utils;

import java.io.Serializable;

public class Equipo implements Serializable {
    String imagen,textoNombre,textoEstadio,id,detalle;

    public Equipo(String textoNombre, String textoEstadio, String imagen, String id,String detalle) {
        this.imagen = imagen;
        this.textoNombre = textoNombre;
        this.textoEstadio = textoEstadio;
        this.id = id;
        this.detalle=detalle;
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

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
