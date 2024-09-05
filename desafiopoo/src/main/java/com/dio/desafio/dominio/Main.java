package com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import com.dio.desafio.dominio.Enums.AreasDoConhecimento;
import com.dio.desafio.dominio.models.Bootcamp;
import com.dio.desafio.dominio.models.Conteudo;
import com.dio.desafio.dominio.models.Mentoria;
import com.dio.desafio.dominio.models.Curso;
import com.dio.desafio.dominio.models.Dev;


public class Main {
    public static void main(String[] args) {

        String descricaoBootcamp = "Bootcamp voltado para conhecimentos java" +
                "focado no framework mais famoso da tecnologia, o Spring Boot, venha se aventurar nesse maravilhoso Bootcamp completo!";

        //Criando um bootcamp
        Bootcamp SpringClaroDio = new Bootcamp("Bootcamp Spring Claro & DIO", descricaoBootcamp,
            AreasDoConhecimento.TECNOLOGIA);

        String descricaoJava1 = "Nesse curso você aprenderá os fundamentos e sintaxe básica do JAVA";
        String descricaoJava2 = "Nesse curso você aprenderá os laços de repetição no JAVA";
        String descricaoJava3 = "Nesse curso você aprenderá a estrutura if e else em JAVA";
        String descricaoJava4 = "Conceitos e os 4 pilares da O.O serão trabalhados nesse módulo";
        String descricaoJava5 = "Aqui você verá o que é uma API, como construi-lá e sua integração com banco de dados";
        
        //Criando Cursos
        Curso java1 = new Curso("Fundamentos da linguagem JAVA", descricaoJava1, AreasDoConhecimento.TECNOLOGIA, 4);
        Curso java2 = new Curso("Laços de repetição", descricaoJava2, AreasDoConhecimento.TECNOLOGIA, 2);
        Curso java3 = new Curso("Estrutua if e else", descricaoJava3, AreasDoConhecimento.TECNOLOGIA, 1);
        Curso java4 = new Curso("Programação Orientada a Objetos", descricaoJava4, AreasDoConhecimento.TECNOLOGIA, 6);
        Curso java5 = new Curso("API's e banco de dados", descricaoJava5, AreasDoConhecimento.TECNOLOGIA, 8);

        //Adicionando um Set de cursos ao bootcamp:
        Set<Conteudo> cursosJava = new LinkedHashSet<Conteudo>();
        cursosJava.add(java5);
        cursosJava.add(java4);
        cursosJava.add(java3);
        cursosJava.add(java2);
        cursosJava.add(java1);
        SpringClaroDio.setConteudos(cursosJava);

        //Também pode ser adicionado individualmente
        Curso java6 = new Curso("CursoUnico", "Curso unico para inserir no bootcamp", AreasDoConhecimento.TECNOLOGIA, 4);
        SpringClaroDio.setConteudos(java6);

        //Caso o conteudo possua uma area do conhecimento diferente uma exceção é lançada:
        //Conteudo mentoria1 = new Mentoria("CursoUnico", "Curso unico para inserir no bootcamp", AreasDoConhecimento.ADIMNISTRACAO, LocalDate.now());
        //SpringClaroDio.setConteudos(mentoria1);

        Dev dev1 = new Dev("Joao Pedro");
        dev1.inscreverBootcamp(SpringClaroDio);
        System.out.println(dev1.getConteudosInscritos());

        //Caso eu adicione um novo conteúdo ele é automaticamente direcionado para os alunos inscritos:
        Conteudo mentoria2 = new Mentoria("Segunda Mentoria", "Mentoria de dúvidas da comunidade",
            AreasDoConhecimento.TECNOLOGIA, LocalDate.now().plusDays(2));
        SpringClaroDio.setConteudos(mentoria2);
        System.out.println(dev1.getConteudosInscritos());

        dev1.progredir();
        dev1.progredir();
        dev1.progredir();
        dev1.progredir();
        dev1.progredir();
        dev1.progredir();
        dev1.progredir();
        //Aqui é a última progressão de acordo com o número de cursos
        dev1.progredir();
        
    }

}
