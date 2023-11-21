package br.edu.ifpi;

import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.entidades.Autenticacao;
import br.edu.ifpi.entidades.Autorizacao;
import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.entidades.Disciplina;
import br.edu.ifpi.entidades.Nota;
import br.edu.ifpi.entidades.Professor;
import br.edu.ifpi.enums.StatusCurso;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Aluno> alunos = new ArrayList<>();
        List<Professor> professores = new ArrayList<>();

        
        Curso curso = new Curso("Programação Java", StatusCurso.ABERTO, 40);

        int opcao;

        do {
            System.out.println("===== Menu =====");
            System.out.println("1. Visualizar informações do curso");
            System.out.println("2. Cadastrar/Matricular aluno no curso");
            System.out.println("3. Cadastrar professor");
            System.out.println("4. Visualizar informações do aluno");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();  

            System.out.println();

            switch (opcao) {
                case 1:
                    visualizarInformacoesCurso(curso);
                    break;

                case 2:
                    cadastrarMatricularAluno(scanner, curso, alunos);
                    break;

                case 3:
                    cadastrarProfessor(scanner, professores);
                    break;

                case 4:
                    visualizarInformacoesAluno(alunos);
                    break;

                case 5:
                    System.out.println("Saindo do sistema. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println(); 

        } while (opcao != 5);
    }

    private static void visualizarInformacoesCurso(Curso curso) {
        System.out.println("===== Informações do Curso =====");
        System.out.println("Nome: " + curso.getNome());
        System.out.println("Status: " + curso.getStatus().getDescricao());
        System.out.println("Carga Horária: " + curso.getCargaHoraria());
    }

    private static void cadastrarMatricularAluno(Scanner scanner, Curso curso, List<Aluno> alunos) {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o ID do aluno: ");
        String id = scanner.nextLine();
        System.out.print("Digite o email do aluno: ");
        String email = scanner.nextLine();

        Aluno novoAluno = new Aluno(nome, id, email);
        alunos.add(novoAluno);
        curso.matricularAluno(novoAluno);

        System.out.println("Aluno cadastrado e matriculado no curso com sucesso!");
    }

    private static void cadastrarProfessor(Scanner scanner, List<Professor> professores) {
        System.out.print("Digite o nome do professor: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o ID do professor: ");
        String id = scanner.nextLine();
        System.out.print("Digite o email do professor: ");
        String email = scanner.nextLine();

        Professor novoProfessor = new Professor(nome, id, email);
        professores.add(novoProfessor);

        System.out.println("Professor cadastrado com sucesso!");
    }

    private static void visualizarInformacoesAluno(List<Aluno> alunos) {
        
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("===== Informações do Aluno =====");
            System.out.println("Nome: " + alunos.get(0).getNome());
            System.out.println("ID: " + alunos.get(0).getId());
            System.out.println("Email: " + alunos.get(0).getEmail());
            System.out.println("Cursos matriculados: " + alunos.get(0).getCursosMatriculados());
        }
    }
}
