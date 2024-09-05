package com.dio.desafio.dominio.models;

import java.time.LocalDate;

import com.dio.desafio.dominio.Enums.AreasDoConhecimento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mentoria extends Conteudo{

    public Mentoria(String titulo, String descricao, Enum<AreasDoConhecimento> areaDoConhecimento, LocalDate data) {
        super(titulo, descricao, areaDoConhecimento);
        this.data = data;
    }

    private LocalDate data;

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }

    @Override
    public String toString() {
        return "Mentoria{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", data=" + getData() +
                '}';
    }
}
