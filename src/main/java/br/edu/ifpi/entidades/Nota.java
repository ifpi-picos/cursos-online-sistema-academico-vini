package br.edu.ifpi.entidades;

public class Nota {
    private String idAluno;
    private String nomeDisciplina;
    private int valor;

    public Nota(String idAluno, String nomeDisciplina, int valor) {
        this.idAluno = idAluno;
        this.nomeDisciplina = nomeDisciplina;
        this.valor = valor;
    }

    public String getIdAluno() {
        return idAluno;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public int getValor() {
        return valor;
    }
}