package br.edu.ifpi.dao;

import java.util.List;

public interface Dao<T> {
    List<T> consultarTodos();
    int cadastrar(T entidade);
    int alterar(T entidade);
    int remover(T entidade);
    T buscarPorId(String id);
}
