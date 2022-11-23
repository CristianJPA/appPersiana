package com.example.persianaautomatica.Modelo;

public class Horario {
    public String horarioSubida;
    public String horarioBajada;

    public Horario() {
    }

    public Horario(String horarioSubida, String horarioBajada) {
        this.horarioSubida = horarioSubida;
        this.horarioBajada = horarioBajada;
    }

    public String getHorarioSubida() {
        return horarioSubida;
    }

    public void setHorarioSubida(String horarioSubida) {
        this.horarioSubida = horarioSubida;
    }

    public String getHorarioBajada() {
        return horarioBajada;
    }

    public void setHorarioBajada(String horarioBajada) {
        this.horarioBajada = horarioBajada;
    }

    @Override
    public String toString() {
        return "Horario{" +
                "horarioSubida='" + horarioSubida + '\'' +
                ", horarioBajada='" + horarioBajada + '\'' +
                '}';
    }
}
