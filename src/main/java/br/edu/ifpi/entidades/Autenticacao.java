package br.edu.ifpi.entidades;

import java.util.HashMap;
import java.util.Map;

public class Autenticacao {
   private Map<String, Usuario> usuarios;

    public Autenticacao() {
        this.usuarios = new HashMap<>();
    }

    public void cadastrarUsuario(String nome, String senha, String tipo) {
        usuarios.put(nome, new Usuario(nome, senha, tipo));
    }

    public boolean autenticarUsuario(String nome, String senha) {
        Usuario usuario = usuarios.get(nome);
        return usuario != null && usuario.getSenha().equals(senha);
    }
}
