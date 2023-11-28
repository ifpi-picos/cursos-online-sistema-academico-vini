package br.edu.ifpi.dao;

import br.edu.ifpi.entidades.Disciplina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDao {

    public List<Disciplina> obterDisciplinasPorAlunoId(String idAluno) {
        List<Disciplina> disciplinas = new ArrayList<>();

        String sql = "SELECT d.* FROM disciplinas d JOIN matriculas m ON d.id = m.idDisciplina WHERE m.idAluno = ?";
        try (Connection connection = Conexao.getConexao();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, idAluno);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Disciplina disciplina = new Disciplina(
                            resultSet.getString("id"),
                            resultSet.getString("nome")
                    );
                    disciplinas.add(disciplina);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return disciplinas;
    }

    public void associarDisciplinaAoProfessor(String nomeDisciplina, String idProfessor) {

        String sql = "INSERT INTO disciplinas (nome, idProfessor) VALUES (?, ?)";
        try (Connection connection = Conexao.getConexao();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, nomeDisciplina);
            statement.setString(2, idProfessor);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}