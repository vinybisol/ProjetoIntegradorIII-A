package com.ucs.modelos;

public class Medico extends Pessoa {
    private String _Especialidade;

    public void setEspecialidade(String especialidade){
        _Especialidade = especialidade;
    }
    public String getEspecialidade(){
        return _Especialidade;
    }
    public String assinatura(){
        return getNome() + " " + getEspecialidade();
    }
}
