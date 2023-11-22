
package br.edu.ifpi.entidades;
import br.edu.ifpi.enums.StatusCurso;
import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private StatusCurso status;
    private int cargaHoraria;
    private ArrayList alunosMatriculados;

    public Curso(String nome, StatusCurso string, int cargaHoraria) {
        this.nome = nome;
        this.status = string;
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

    public ArrayList<Object> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public void matricularAluno(Aluno aluno) {
        alunosMatriculados.add(aluno);
    }

    public Aluno[] getAlunoMatriculado() {
        return null;
    }
}
