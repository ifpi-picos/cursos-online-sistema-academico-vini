package br.edu.ifpi.dao;

import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.entidades.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcurarAluno {

    public static Aluno buscarAlunoPorId(String idAluno) {
        String sql = "SELECT * FROM alunos WHERE id = ?";
        try (Connection connection = Conexao.getConexao();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, idAluno);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Aluno(
                            resultSet.getString("nome"),
                            resultSet.getString("id"),
                            resultSet.getString("email"),
                            resultSet.getString("tipo")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Aluno procurarAluno(Curso curso, String idAluno) {
        return null;
    }
}
