package com.example.t03_repaso.utils;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre,apellido;
    private int telefono;
    private boolean experiencia;

    public Persona(){

    }

    public Persona(String nombre,String apellido,int telefono,boolean experiencia){
        this.nombre=nombre;
        this.apellido=apellido;
        this.telefono=telefono;
        this.experiencia=experiencia;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setExperiencia(boolean experiencia) {
        this.experiencia = experiencia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean isExperiencia() {
        return experiencia;
    }
}
