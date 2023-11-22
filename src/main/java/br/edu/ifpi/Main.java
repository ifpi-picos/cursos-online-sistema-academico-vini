package br.edu.ifpi;

import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.entidades.Autenticacao;
import br.edu.ifpi.entidades.Autorizacao;
import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.entidades.Disciplina;
import br.edu.ifpi.entidades.Nota;
import br.edu.ifpi.entidades.Professor;
import br.edu.ifpi.enums.StatusCurso;
import br.edu.ifpi.entidades.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

     private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Usuario> usuarios = new ArrayList<>();
        Curso cursoJava = new Curso("Programação Java", "Aberto", 40);

        // Criando alguns exemplos de usuários com senhas
        Aluno aluno1 = new Aluno("Joao", "aluno1", "joao@email.com", null);
        aluno1.setSenha("senhaAluno1");

        Professor professor1 = new Professor("ProfSilva", "professor1", "silva@email.com", null);
        professor1.setSenha("senhaProfessor1");

        // Adicionando usuários à lista
        usuarios.add(aluno1);
        usuarios.add(professor1);

        // Realizando o login
        realizarLogin(usuarios, cursoJava);
    }

    private static void realizarLogin(List<Usuario> usuarios, Curso curso) {
        System.out.print("Digite o nome de usuário: ");
        String nomeUsuario = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        // Verifica se o usuário existe e valida a senha
        Usuario usuario = buscarUsuario(usuarios, nomeUsuario, senha);
        if (usuario != null) {
            if (usuario instanceof Aluno) {
                menuAluno((Aluno) usuario, curso);
            } else if (usuario instanceof Professor) {
                menuProfessor((Professor) usuario, curso);
            } else {
                System.out.println("Tipo de usuário desconhecido.");
            }
        } else {
            System.out.println("Credenciais inválidas. Tente novamente.");
            realizarLogin(usuarios, curso);
        }
    }

    private static Usuario buscarUsuario(List<Usuario> usuarios, String nomeUsuario, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nomeUsuario) && usuario.validarSenha(senha)) {
                return usuario;
            }
        }
        return null;
    }

    private static void menuAluno(Aluno aluno, Curso curso) {
        int opcao;

        do {
            System.out.println("===== Menu Aluno =====");
            System.out.println("1. Ver Disciplinas Matriculadas");
            System.out.println("2. Ver Notas");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    aluno.matricularEmDisciplina("Matemática");
                    aluno.matricularEmDisciplina("História");
                    aluno.matricularEmDisciplina("Programação");
                    System.out.println("Disciplinas matriculadas com sucesso!");
                    break;
                case 2:
                    aluno.verDisciplinasMatriculadas();
                    aluno.verNotas();
                    break;
                case 3:
                    System.out.println("Saindo do sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println(); // Adiciona uma linha em branco para melhorar a leitura

        } while (opcao != 3);
    }

    private static void menuProfessor(Professor professor, Curso curso) {
        int opcao;

        do {
            System.out.println("===== Menu Professor =====");
            System.out.println("1. Associar Disciplina");
            System.out.println("2. Dar Nota");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome da disciplina: ");
                    String disciplina = scanner.nextLine();
                    professor.associarDisciplina(disciplina);
                    System.out.println("Disciplina associada com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o ID do aluno: ");
                    String idAluno = scanner.nextLine();
                    System.out.print("Digite a disciplina: ");
                    disciplina = scanner.nextLine();
                    System.out.print("Digite a nota: ");
                    int nota = scanner.nextInt();
                    scanner.nextLine();  // Limpar o buffer do scanner

                    Aluno aluno = procurarAluno(curso, idAluno);
                    if (aluno != null) {
                        professor.darNota(aluno, disciplina, nota);
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Saindo do sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println(); // Adiciona uma linha em branco para melhorar a leitura

        } while (opcao != 3);
    }

    private static Aluno procurarAluno(Curso curso, String idAluno) {
        for (Aluno aluno : curso.getAlunoMatriculado()) {
            if (aluno.getId().equals(idAluno)) {
                return aluno;
            }
        }
        return null;
    }
}