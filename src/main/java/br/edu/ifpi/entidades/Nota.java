package br.edu.ifpi.entidades;

public class Nota {
    private Aluno aluno;
    private Disciplina disciplina;
    private double valor;

    public Nota(Aluno aluno, Disciplina disciplina, double valor) {
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.valor = valor;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public double getValor() {
        return valor;
    }
}
