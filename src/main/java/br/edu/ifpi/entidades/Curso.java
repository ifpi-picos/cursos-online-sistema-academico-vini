
package br.edu.ifpi.entidades;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private boolean status;
    private int cargaHoraria;
    private List<Aluno> alunosMatriculados;

    public Curso(String nome, boolean status, int cargaHoraria) {
        this.nome = nome;
        this.status = status;
        this.cargaHoraria = cargaHoraria;
        this.alunosMatriculados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
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
}
