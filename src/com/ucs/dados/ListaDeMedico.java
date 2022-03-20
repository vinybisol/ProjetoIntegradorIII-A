package com.ucs.dados;


import com.ucs.modelos.Medico;

import java.util.ArrayList;
import java.util.List;

public class ListaDeMedico {
    public static List <Medico> _listaMedico = new ArrayList<Medico>();

    public static List<Medico> RetornaListaDeMedicoPorEspecialidade(String especialidade){
        List<Medico> listaFiltrada = new ArrayList<>();
        _listaMedico.forEach(listaMedico -> {
            if(listaMedico.Especialidade.equalsIgnoreCase(especialidade)){
                listaFiltrada.add(listaMedico);
            };
        });
        return listaFiltrada;
    }
}
