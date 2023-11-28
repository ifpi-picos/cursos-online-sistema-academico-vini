package br.edu.ifpi.dao;

import br.edu.ifpi.entidades.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDao implements Dao<Aluno> {

    @Override
    public List<Aluno> consultarTodos() {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos";
        try (Connection connection = Conexao.getConexao();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Aluno aluno = new Aluno(
                        resultSet.getString("nome"),
                        resultSet.getString("id"),
                        resultSet.getString("email"),
                        resultSet.getString("tipo")
                );
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alunos;
    }

    @Override
    public int cadastrar(Aluno aluno) {
        String sql = "INSERT INTO alunos (nome, id, email, tipo) VALUES (?, ?, ?, ?)";
        try (Connection connection = Conexao.getConexao();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, aluno.getNome());
            statement.setString(2, aluno.getId());
            statement.setString(3, aluno.getEmail());
            statement.setString(4, aluno.getTipo());

            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int alterar(Aluno aluno) {
        String sql = "UPDATE alunos SET nome = ?, email = ?, tipo = ? WHERE id = ?";
        try (Connection connection = Conexao.getConexao();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, aluno.getNome());
            statement.setString(2, aluno.getEmail());
            statement.setString(3, aluno.getTipo());
            statement.setString(4, aluno.getId());

            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int remover(Aluno aluno) {
        String sql = "DELETE FROM alunos WHERE id = ?";
        try (Connection connection = Conexao.getConexao();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, aluno.getId());

            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Aluno buscarPorId(String id) {
        String sql = "SELECT * FROM alunos WHERE id = ?";
        try (Connection connection = Conexao.getConexao();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, id);

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
}
