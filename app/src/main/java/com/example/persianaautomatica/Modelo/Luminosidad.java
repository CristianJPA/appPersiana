package com.example.persianaautomatica.Modelo;

public class Luminosidad {
    public int luminosidadSubida;
    public int luminosidadBajada;

    public Luminosidad() {
    }

    public Luminosidad(int luminosidadSubida, int luminosidadBajada) {
        this.luminosidadSubida = luminosidadSubida;
        this.luminosidadBajada = luminosidadBajada;
    }

    public int getLuminosidadSubida() {
        return luminosidadSubida;
    }

    public void setLuminosidadSubida(int luminosidadSubida) {
        this.luminosidadSubida = luminosidadSubida;
    }

    public int getLuminosidadBajada() {
        return luminosidadBajada;
    }

    public void setLuminosidadBajada(int luminosidadBajada) {
        this.luminosidadBajada = luminosidadBajada;
    }

    @Override
    public String toString() {
        return "Luminosidad{" +
                "luminosidadSubida=" + luminosidadSubida +
                ", luminosidadBajada=" + luminosidadBajada +
                '}';
    }
}

