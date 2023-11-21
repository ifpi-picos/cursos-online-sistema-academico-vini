//classe curso
package br.edu.ifpi.entidades;

public class Curso {
    private String nome;
    private boolean status;
    private int cargaHoraria;

    
    public Curso(String nome, boolean status, int cargaHoraria) {
        this.nome = nome;
        this.status = status;
        this.cargaHoraria = cargaHoraria;
    }

    
    public String getNome() {
        return nome;
    }

    public boolean getStatus() {
        return status;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
