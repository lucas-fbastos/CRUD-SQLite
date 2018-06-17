package com.example.lucas.crudsqlite;

public class Pessoa {

    private String nome;
    private int idade;
    private Boolean casada;

    public int getIdade(){
        return idade;
    }
    public String getNome(){
        return nome;
    }
    public boolean getCasada(){
        return casada;
    }

    public String setNome(String nome){
        nome = this.nome;
        return nome;
    }

    public int setIdade(int idade){
        idade = this.idade;
        return idade;
    }
    public boolean setCasada(boolean casada){
        casada = this.casada;
        return casada;
    }
}
