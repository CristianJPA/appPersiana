package com.example.persianaautomatica.Modelo;

public class Registro {
    public String id;
    public int voltaje;
    public String hora;
    public String fecha;

    public Registro() {
    }

    public Registro(String id, int voltaje, String hora, String fecha) {
        this.id = id;
        this.voltaje = voltaje;
        this.hora = hora;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(int voltaje) {
        this.voltaje = voltaje;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "id='" + id + '\'' +
                ", voltaje=" + voltaje +
                ", hora='" + hora + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
