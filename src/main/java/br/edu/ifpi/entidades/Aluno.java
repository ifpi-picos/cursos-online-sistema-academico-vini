package br.edu.ifpi.entidades;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aluno extends Usuario {
    private Map<String, Integer> notas;
    private Map<String, Boolean> disciplinasMatriculadas;

    public Aluno(String nome, String id, String email, String senha) {
        super(nome, id, email, "aluno", senha);
        this.notas = new HashMap<>();
        this.disciplinasMatriculadas = new HashMap<>();
    }

    public void matricularEmDisciplina(String disciplina) {
        disciplinasMatriculadas.put(disciplina, true);
        notas.put(disciplina, 0); // Inicializa a nota como 0
    }

    public void cancelarMatriculaEmDisciplina(String disciplina) {
        disciplinasMatriculadas.remove(disciplina);
        notas.remove(disciplina);
    }

    public void verDisciplinasMatriculadas() {
        System.out.println("Disciplinas matriculadas pelo aluno " + getNome() + ": " + disciplinasMatriculadas.keySet());
    }

    public void verNotas() {
        System.out.println("Notas do aluno " + getNome() + ":");
        for (Map.Entry<String, Integer> entry : notas.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void receberNota(String disciplina, int nota) {
        if (disciplinasMatriculadas.containsKey(disciplina)) {
            notas.put(disciplina, nota);
            System.out.println("Nota recebida com sucesso!");
        } else {
            System.out.println("Aluno não está matriculado na disciplina " + disciplina);
        }
    }

    public Object getId() {
        return null;
    }
}
