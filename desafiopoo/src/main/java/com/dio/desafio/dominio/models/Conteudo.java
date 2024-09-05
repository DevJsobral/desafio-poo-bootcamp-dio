package com.dio.desafio.dominio.models;

import java.util.Objects;

import com.dio.desafio.dominio.Enums.AreasDoConhecimento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Conteudo {

    protected static final double XP_PADRAO = 10d;

    private String titulo;
    private String descricao;
    private Enum<AreasDoConhecimento> areaDoConhecimento;
    

    public abstract double calcularXp();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conteudo conteudo = (Conteudo) o;
        return Objects.equals(titulo, conteudo.titulo) &&
               areaDoConhecimento == conteudo.areaDoConhecimento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, areaDoConhecimento);
    }

}
