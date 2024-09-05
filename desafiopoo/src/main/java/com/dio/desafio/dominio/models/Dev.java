package com.dio.desafio.dominio.models;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import com.dio.desafio.dominio.Exceptions.BootcampIndisponivelException;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;

@Getter
@Setter
@RequiredArgsConstructor
public class Dev {

    @NonNull
    private String nome;

    //Conteudos Inscritos e Conclu
    @Setter(AccessLevel.NONE)
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();

    @Setter(AccessLevel.NONE)
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp) {
        //Para o aluno se matricular no bootcamp, o bootcamp deve ter ao minimo 5 conteudos disponíveis para estudo
        if (bootcamp.getConteudos().size() > 5) {
            this.conteudosInscritos.addAll(bootcamp.getConteudos());
            bootcamp.getDevsInscritos().add(this);        
        } else {
            throw new BootcampIndisponivelException("Você não pode se matricular no bootcamp pois" +
            "ainda não existem conteúdos suficientes disponíveis");
        }
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            double xp = this.calcularTotalXp();
            System.out.println("Você finalizou todo o conteúdo do Bootcamp! A sua Xp adquirida foi de: " + xp + "pontos.");
        }
    }

    public double calcularTotalXp() {
        return this.conteudosConcluidos.stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
