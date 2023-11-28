package br.edu.ifpi.entidades;

import br.edu.ifpi.enums.StatusCurso;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private StatusCurso status;
    private int cargaHoraria;
    private List<Aluno> alunosMatriculados;

    public Curso(String nome, StatusCurso status, int cargaHoraria) {
        this.nome = nome;
        this.status = status;
        this.cargaHoraria = cargaHoraria;
        this.alunosMatriculados = new ArrayList<>();
    }

   

    public Curso(String nome2, String string, int cargaHoraria2) {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StatusCurso getStatus() {
        return status;
    }

    public void setStatus(StatusCurso status) {
        this.status = status;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public void matricularAluno(Aluno aluno) {
        alunosMatriculados.add(aluno);
    }

    public Aluno[] getAlunosMatriculadosArray() {
        return alunosMatriculados.toArray(new Aluno[0]);
    }
}
