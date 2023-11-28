package br.edu.ifpi.dao;

import br.edu.ifpi.entidades.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDao implements Dao<Professor> {

    @Override
    public int cadastrar(Professor professor) {
        String sql = "INSERT INTO professores (nome, id, email, tipo) VALUES (?, ?, ?, ?)";
        try (Connection connection = Conexao.getConexao();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, professor.getNome());
            statement.setString(2, professor.getId());
            statement.setString(3, professor.getEmail());
            statement.setString(4, professor.getTipo());

            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int alterar(Professor professor) {
        String sql = "UPDATE professores SET nome = ?, email = ? WHERE id = ?";
        try (Connection connection = Conexao.getConexao();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, professor.getNome());
            statement.setString(2, professor.getEmail());
            statement.setString(3, professor.getId());

            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int remover(Professor professor) {
        String sql = "DELETE FROM professores WHERE id = ?";
        try (Connection connection = Conexao.getConexao();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, professor.getId());

            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

 
    @Override
    public List<Professor> consultarTodos() {
        List<Professor> professores = new ArrayList<>();

        try (Connection connection = Conexao.getConexao();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM professores");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String id = resultSet.getString("id");
                String email = resultSet.getString("email");

                Professor professor = new Professor(nome, id, email, "professor");
                professores.add(professor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return professores;
    }

    @Override
    public Professor buscarPorId(String idProfessor) {
        String sql = "SELECT * FROM professores WHERE id = ?";
        try (Connection connection = Conexao.getConexao();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, idProfessor);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Professor(
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
}
