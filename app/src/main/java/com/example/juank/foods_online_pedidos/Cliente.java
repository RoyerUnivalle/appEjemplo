package com.example.juank.foods_online_pedidos;

import android.os.Bundle;

import java.io.Serializable;

public class Cliente implements Serializable {

    String nombre;
    String direccion;

    public Cliente(String nombre, String direccion){
        this.nombre=nombre;
        this.direccion=direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
