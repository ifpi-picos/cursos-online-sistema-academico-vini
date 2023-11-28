package br.edu.ifpi.entidades;

import java.util.List;

import br.edu.ifpi.dao.DisciplinaDao;
import br.edu.ifpi.dao.NotaDao;

public class Aluno extends Usuario {
    private List<Disciplina> disciplinasMatriculadas;

    public Aluno(String nome, String id, String email, String tipo, List<Disciplina> disciplinasMatriculadas) {
        super(nome, id, email, tipo);
        this.disciplinasMatriculadas = disciplinasMatriculadas;
    }

    public Aluno(String nome, String id, String email, String tipo) {
        super(nome, id, email, tipo);
    }

    public List<Disciplina> getDisciplinasMatriculadas() {
        return disciplinasMatriculadas;
    }

    public void setDisciplinasMatriculadas(List<Disciplina> disciplinasMatriculadas) {
        this.disciplinasMatriculadas = disciplinasMatriculadas;
    }

    @Override
    public String getId() {
        return super.getId();  
    }

    @Override
    public String getEmail() {
        return super.getEmail(); 
    }

    public void verDisciplinasMatriculadasNoBancoDeDados() {
   
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        disciplinasMatriculadas = disciplinaDao.obterDisciplinasPorAlunoId(this.getId());
        
      
        System.out.println("Disciplinas Matriculadas:");
        for (Disciplina disciplina : disciplinasMatriculadas) {
            System.out.println(disciplina.getNome());
        }
    }

    public void verNotasNoBancoDeDados() {
 
        NotaDao notaDao = new NotaDao();
        List<Nota> notas = notaDao.obterNotasPorAlunoId(this.getId());

      
        System.out.println("Notas:");
        for (Nota nota : notas) {
            System.out.println("Disciplina: " + nota.getNomeDisciplina() + ", Nota: " + nota.getValor());
        }
    }

}
