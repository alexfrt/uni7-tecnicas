package br.edu.uni7.tecnicasapp1.model;

public class Materia {

    private String titulo;
    private String texto;

    public Materia() {

    }

    public Materia(String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
