package br.edu.ifpi.entidades;

import java.util.HashMap;
import java.util.Map;

public class Autorizacao {
    private Map<String, String> permissoes;

    public Autorizacao() {
        this.permissoes = new HashMap<>();
    }

    public void atribuirTipo(String nomeUsuario, String tipo) {
        permissoes.put(nomeUsuario, tipo);
    }

    public String obterTipo(String nomeUsuario) {
        return permissoes.get(nomeUsuario);
    }
}
