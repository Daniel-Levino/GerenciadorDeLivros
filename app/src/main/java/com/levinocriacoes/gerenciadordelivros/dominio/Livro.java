package com.levinocriacoes.gerenciadordelivros.dominio;

public class Livro {
    private Long id;
    private String titulo, autor, editora;
    private int emprestado;

    public Livro(Long id, String titulo, String autor, String editora, int emprestado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.emprestado = emprestado;
    }

    //GETTERS AND SETTERS
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public String getAutor() {return autor;}
    public void setAutor(String autor) {this.autor = autor;}
    public String getEditora() {return editora;}
    public void setEditora(String editora) {this.editora = editora;}
    public int getEmprestado() {return emprestado;}
    public void setEmprestado(int emprestado) {
        if(emprestado==1 || emprestado ==0)
            this.emprestado = emprestado;
    }
}