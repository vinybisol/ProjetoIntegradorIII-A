package com.ucs.dados;


import com.ucs.modelos.Medico;
import com.ucs.modelos.Paciente;

import java.util.ArrayList;
import java.util.List;

public class ListaDeMedico {
    private static List <Medico> _listaMedico = new ArrayList();

    public static List<Medico> retornaListaDeMedicoPorEspecialidade(String especialidade){
        List<Medico> listaFiltrada = new ArrayList<>();
        _listaMedico.forEach(listaMedico -> {
            if(listaMedico.Especialidade.equalsIgnoreCase(especialidade)){
                listaFiltrada.add(listaMedico);
            };
        });
        return listaFiltrada;
    }
    public static List<Medico> retornaTodos(){
        return _listaMedico;
    }
    public static void adicionarMedico(Medico medico){
        _listaMedico.add(medico);
    }

}
