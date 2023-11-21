package br.edu.ifpi.entidades;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private List<Aluno> alunosMatriculados;

    public Disciplina(String nome) {
        this.nome = nome;
        this.alunosMatriculados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void matricularAluno(Aluno aluno) {
        alunosMatriculados.add(aluno);
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }
}
