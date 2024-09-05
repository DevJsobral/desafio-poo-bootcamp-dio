package com.dio.desafio.dominio.models;

import com.dio.desafio.dominio.Enums.AreasDoConhecimento;


public class Curso extends Conteudo {

    private int cargaHoraria;

    public Curso(String titulo, String descricao, Enum<AreasDoConhecimento> areaDoConhemento, int cargaHoraria) {
        super(titulo, descricao, areaDoConhemento);
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }
}
