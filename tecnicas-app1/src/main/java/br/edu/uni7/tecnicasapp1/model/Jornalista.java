package br.edu.uni7.tecnicasapp1.model;

public class Jornalista {

    private String nome;
    private String usuario;
    private String senha;

    public Jornalista() {

    }

    public Jornalista(String nome, String usuario, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
