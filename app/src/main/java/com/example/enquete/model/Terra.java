package com.example.enquete.model;

import java.io.Serializable;

public class Terra implements Serializable {

    String descricao;
    int caminho;
    String nome = null;

    public Terra (){

    }

    public Terra (String nome, String descricao, int caminho){
        this.caminho = caminho;
        this.descricao = descricao;
        this.nome = nome;
    }

    public void setCaminho(int caminho) {
        this.caminho = caminho;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCaminho() {
        return caminho;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return nome;
    }
}

