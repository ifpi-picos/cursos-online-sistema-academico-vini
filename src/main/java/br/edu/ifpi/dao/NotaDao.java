package br.edu.ifpi.dao;

import br.edu.ifpi.entidades.Nota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotaDao {

    public List<Nota> obterNotasPorAlunoId(String idAluno) {
        List<Nota> notas = new ArrayList<>();

        String sql = "SELECT * FROM notas WHERE idAluno = ?";
        try (Connection connection = Conexao.getConexao();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, idAluno);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Nota nota = new Nota(
                            resultSet.getString("idAluno"),
                            resultSet.getString("nomeDisciplina"),
                            resultSet.getInt("valor")
                    );
                    notas.add(nota);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notas;
    }

    public void registrarNota(String id, String nomeDisciplina, int nota) {
    }


}