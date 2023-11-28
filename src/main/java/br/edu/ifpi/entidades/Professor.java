package br.edu.ifpi.entidades;

import java.util.List;

import br.edu.ifpi.dao.DisciplinaDao;
import br.edu.ifpi.dao.NotaDao;

public class Professor extends Usuario {
    private List<Disciplina> disciplinasAssociadas;

    public Professor(String nome, String id, String email, String tipo, List<Disciplina> disciplinasAssociadas) {
        super(nome, id, email, tipo);
        this.disciplinasAssociadas = disciplinasAssociadas;
    }

    public Professor(String nome, String id, String email, String tipo) {
        super(nome, id, email, tipo);
    }

    public List<Disciplina> getDisciplinasAssociadas() {
        return disciplinasAssociadas;
    }

    public void setDisciplinasAssociadas(List<Disciplina> disciplinasAssociadas) {
        this.disciplinasAssociadas = disciplinasAssociadas;
    }

    public void associarDisciplinaNoBancoDeDados(String nomeDisciplina) {
       
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        disciplinaDao.associarDisciplinaAoProfessor(nomeDisciplina, this.getId());
    }

    public void darNotaNoBancoDeDados(Aluno aluno, String nomeDisciplina, int nota) {
      
        NotaDao notaDao = new NotaDao();
        notaDao.registrarNota(aluno.getId(), nomeDisciplina, nota);
    }
}
