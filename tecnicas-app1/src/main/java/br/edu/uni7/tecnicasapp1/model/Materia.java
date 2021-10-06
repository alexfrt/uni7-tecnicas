package br.edu.uni7.tecnicasapp1.model;

import java.util.Date;

public class Materia {

    private String titulo;
    private String autor;
    private String conteudo;
    private Date data;

    public Materia() {

    }

    public Materia(String titulo, String autor, String conteudo, Date data) {
        this.titulo = titulo;
        this.autor = autor;
        this.conteudo = conteudo;
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
