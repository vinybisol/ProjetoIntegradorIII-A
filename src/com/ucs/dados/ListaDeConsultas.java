package com.ucs.dados;

import com.ucs.modelos.Consulta;

import java.util.ArrayList;
import java.util.List;

public class ListaDeConsultas {
    private static List<Consulta> _listaConsulta = new ArrayList<>();

    public static void incluirNoInicio(Consulta umaConsulta) {

    }

    public static void incluirNoFim(Consulta umaConsulta) {

        _listaConsulta.add(umaConsulta);
    }

    public static long tamanho() {

        long tamanhoDaLista = _listaConsulta.stream().count();
        return  tamanhoDaLista;
    }

    public static long proximoId() {
        long tamanhoDaLista = tamanho();
        return  tamanhoDaLista ++;
    }

    public static Consulta get(int indice) {
        return _listaConsulta.get(indice);
    }

    public static List<Consulta> retornaTodos() {
        return _listaConsulta;
    }

    public static  List<Consulta> retornaFiltrada(String medico, String paciente){
        var listaFiltrada = new ArrayList<Consulta>();

        if(medico.isEmpty() && paciente.isEmpty()){
            return retornaTodos();
        }
        _listaConsulta.forEach(lista -> {
            if(!medico.isEmpty() && medico.equalsIgnoreCase(lista.Medico) && paciente.isEmpty()){
                listaFiltrada.add(lista);
            }
            if(!paciente.isEmpty() && paciente.equalsIgnoreCase(lista.Paciente) && medico.isEmpty()){
                listaFiltrada.add(lista);
            }
            if(!paciente.isEmpty() & !medico.isEmpty() && paciente.equalsIgnoreCase(lista.Paciente) && medico.equalsIgnoreCase(lista.Medico) ){
                listaFiltrada.add(lista);
            }
        });
        return listaFiltrada;
    }
}