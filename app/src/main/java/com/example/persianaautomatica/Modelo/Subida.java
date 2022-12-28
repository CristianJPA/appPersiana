package com.example.persianaautomatica.Modelo;

public class Subida {
    public int subir;
    public int detener;
    public int bajar;

    public Subida() {
    }

    public Subida(int subir, int detener, int bajar) {
        this.subir = subir;
        this.detener = detener;
        this.bajar = bajar;
    }

    public int getSubir() {
        return subir;
    }

    public void setSubir(int subir) {
        this.subir = subir;
    }

    public int getDetener() {
        return detener;
    }

    public void setDetener(int detener) {
        this.detener = detener;
    }

    public int getBajar() {
        return bajar;
    }

    public void setBajar(int bajar) {
        this.bajar = bajar;
    }

    @Override
    public String toString() {
        return "Subida{" +
                "subir=" + subir +
                ", detener=" + detener +
                ", bajar=" + bajar +
                '}';
    }
}
