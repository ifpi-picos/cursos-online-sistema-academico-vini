package br.edu.ifpi.entidades;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private String id;
    private String email;
    private List<Curso> cursosMatriculados;

    public Aluno(String nome, String id, String email) {
        this.nome = nome;
        this.id = id;
        this.email = email;
        this.cursosMatriculados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Curso> getCursosMatriculados() {
        return cursosMatriculados;
    }

    public void matricularEmCurso(Curso curso) {
        cursosMatriculados.add(curso);
    }

    public void cancelarMatricula(Curso curso) {
        cursosMatriculados.remove(curso);
    }
}
