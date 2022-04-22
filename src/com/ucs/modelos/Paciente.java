package com.ucs.modelos;

public class Paciente extends Pessoa {
    private String _endereco;

    public void setEndereco(String endereco){
        _endereco = endereco;
    }
    public String getEndereco(){
        return _endereco;
    }

    @Override
    public String toString() {
        return getNome() + " " + getEndereco();
    }
}
