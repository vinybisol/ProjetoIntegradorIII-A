package com.ucs.dados;

import com.ucs.modelos.Paciente;

import java.util.ArrayList;
import java.util.List;


public class ListaDePaciente {
    private static List <Paciente> _listaPaciente = new ArrayList();

    public static List<Paciente> retornaTodos(){
        return _listaPaciente;
    }
    public static void adicionarPaciente(Paciente paciente){
        _listaPaciente.add(paciente);
    }

}
