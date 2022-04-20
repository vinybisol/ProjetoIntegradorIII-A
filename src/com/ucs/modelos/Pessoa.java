package com.ucs.modelos;

public class Pessoa {
    private String _nome;
    private String _CPF;

    public void setNome(String nome){
        _nome = nome;
    }
    public String getNome(){
        return _nome;
    }
    public void setCPF(String cpf){
        _CPF = cpf;
    }
    public String getCPF(){
        return _CPF;
    }
}
