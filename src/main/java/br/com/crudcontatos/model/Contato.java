package br.com.crudcontatos.model;

import java.util.Date;

public class Contato {
    private int id;
    private String nome;
    private String telefone;
    private Date dataCadastro;

    public Contato() {
        this.dataCadastro = new Date();
    }

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataCadastro = new Date();
    }

    public Contato(int id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.dataCadastro = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "\nDados do Cliente:"
                + "\nID: " + this.id
                + "\nNome: " + this.nome
                + "\nIdade: " + this.telefone
                + "\nData de cadastro: " + this.dataCadastro;
    }
}
