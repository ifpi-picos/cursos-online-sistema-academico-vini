package br.edu.ifpi.entidades;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    private String nome;
    private String id;
    private String email;
    private List<Curso> cursosMinistrados;

    public Professor(String nome, String id, String email) {
        this.nome = nome;
        this.id = id;
        this.email = email;
        this.cursosMinistrados = new ArrayList<>();
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

    public List<Curso> getCursosMinistrados() {
        return cursosMinistrados;
    }

    public void associarCurso(Curso curso) {
        cursosMinistrados.add(curso);
    }
}
