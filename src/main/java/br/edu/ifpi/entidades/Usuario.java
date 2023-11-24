package br.edu.ifpi.entidades;

public class Usuario {
    private String nome;
    private String senha;
    private String tipo;
    //tipo tras a ideia de aluno, professor ou adm.

    public Usuario(String nome, String senha, String tipo, String string, String senha2) {
        this.nome = nome;
        this.senha = senha;
        this.tipo = tipo;
    }

    public Usuario(String nome2, String id, String email, String string) {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean validarSenha(String senha) {
        return this.senha.equals(senha);
    }
}
