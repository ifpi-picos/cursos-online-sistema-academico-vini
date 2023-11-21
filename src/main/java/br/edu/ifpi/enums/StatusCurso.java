package br.edu.ifpi.enums;

public enum StatusCurso {
    ABERTO("Aberto"),
    FECHADO("Fechado");

    private final String descricao;

    StatusCurso(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}