package br.edu.ifpi.entidades;

import java.util.List;

public class Professor extends Usuario {
    private List<String> disciplinasMinistradas;

    public Professor(String nome, String id, String email, String senha) {
        super(nome, id, email, "professor", senha);
    }

    public void associarDisciplina(String disciplina) {
        disciplinasMinistradas.add(disciplina);
    }

    public void darNota(Aluno aluno, String disciplina, int nota) {
        if (disciplinasMinistradas.contains(disciplina)) {
            aluno.receberNota(disciplina, nota);
            System.out.println("Nota atribuída com sucesso!");
        } else {
            System.out.println("Professor não ministra a disciplina " + disciplina);
        }
    }

    public String getEmail() {
        return null;
    }
}