package com.dio.desafio.dominio.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import com.dio.desafio.dominio.Enums.AreasDoConhecimento;
import com.dio.desafio.dominio.Exceptions.InvalidAreaException;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bootcamp {

    private String nome;
    private String descricao;
    private Enum<AreasDoConhecimento> areaDoConhecimento;

    @Setter(AccessLevel.NONE)
    private final LocalDate dataInicial = LocalDate.now();

    @Setter(AccessLevel.NONE)
    private final LocalDate dataFinal = dataInicial.plusDays(45);
    
    //Não vamos criar o set pois os devs serão inscritos na sua própria classe ao realizar a inscrição.
    @Setter(AccessLevel.NONE)
    private Set<Dev> devsInscritos = new HashSet<>();

    private Set<Conteudo> conteudos = new LinkedHashSet<>();
    
    //Polimorfismo em diferentes formas de adicionar conteúdos, sendo uma Collection de conteúdos ou apenas um.
    //Em ambos os métodos temos uma exception personalizada, além de adicionar o conteudo a lista de conteudos inscritos dos devsInscritos automaticamente
    //a cada nova adição. além dos cursos só serem adicionados se já não existirem dentro do Bootcamp
    public void setConteudos(Set<Conteudo> conteudos) {
        boolean mesmaArea = conteudos.stream()
                .allMatch(conteudo -> conteudo.getAreaDoConhecimento() == this.getAreaDoConhecimento());
        if (mesmaArea) {
            conteudos.forEach(conteudo -> {
                if (!this.conteudos.contains(conteudo)) {
                    this.conteudos.add(conteudo);
                }
            });
            if (devsInscritos.size() > 0) {
                this.getDevsInscritos().forEach(x -> x.getConteudosInscritos().addAll(conteudos));
            }
        } else {
            throw new InvalidAreaException("Todos os conteúdos a serem inseridos nesse Bootcamp devem ser da área de: "
            + this.getAreaDoConhecimento());
        }
    }
    
    public void setConteudos(Conteudo conteudo) {
        if (conteudo.getAreaDoConhecimento() == this.getAreaDoConhecimento() && !this.conteudos.contains(conteudo)) {
            this.conteudos.add(conteudo);
            if (devsInscritos.size() > 0) {
                this.getDevsInscritos().forEach(x -> x.getConteudosInscritos().add(conteudo));
            }
        }else{
            throw new InvalidAreaException("Todos os conteúdos a serem inseridos nesse Bootcamp devem ser da área de: "
            + this.getAreaDoConhecimento());
        }
    }
    
    public Bootcamp(String nome, String descricao, Enum<AreasDoConhecimento> areaDoConhecimento) {
        this.nome = nome;
        this.descricao = descricao;
        this.areaDoConhecimento = areaDoConhecimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome) && Objects.equals(descricao, bootcamp.descricao) && Objects.equals(dataInicial, bootcamp.dataInicial) && Objects.equals(dataFinal, bootcamp.dataFinal) && Objects.equals(devsInscritos, bootcamp.devsInscritos) && Objects.equals(conteudos, bootcamp.conteudos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataInicial, dataFinal, devsInscritos, conteudos);
    }
}
