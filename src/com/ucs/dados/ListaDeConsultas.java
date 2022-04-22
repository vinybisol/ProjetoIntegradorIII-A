package com.ucs.dados;

import com.ucs.modelos.Consulta;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ListaDeConsultas {
    private static List<Consulta> _listaConsulta = new ArrayList<>();

    public static void incluirNoInicio(Consulta umaConsulta) {

    }

    public static void incluirNoFim(Consulta umaConsulta) {

        _listaConsulta.add(umaConsulta);
    }

    public static long tamanho() {

        long tamanhoDaLista = _listaConsulta.stream().count();
        return tamanhoDaLista;
    }

    public static long proximoId() {
        //long tamanhoDaLista = tamanho();
        //return tamanhoDaLista++;
        var random = Math.random() * 100;
        var ret = Math.round(random);
        return ret;
    }

    public static Consulta get(int indice) throws Exception {
        for (int i = 0; i < _listaConsulta.size(); i++) {
            long id = _listaConsulta.get(i).ID;
            if(id == indice){
                return _listaConsulta.get(i);
            }
        }
        throw new NullPointerException("");
    }

    public static List<Consulta> retornaTodos() {
        return ordenar(_listaConsulta);
    }

    public static List<Consulta> retornaFiltrada(String medico, String paciente) {
        var listaFiltrada = new ArrayList<Consulta>();

        if (medico.isEmpty() && paciente.isEmpty()) {
            return retornaTodos();
        }
        _listaConsulta.forEach(lista -> {
            if (!medico.isEmpty() && medico.equalsIgnoreCase(lista.Medico) && paciente.isEmpty()) {
                listaFiltrada.add(lista);
            }
            if (!paciente.isEmpty() && paciente.equalsIgnoreCase(lista.Paciente) && medico.isEmpty()) {
                listaFiltrada.add(lista);
            }
            if (!paciente.isEmpty() & !medico.isEmpty() && paciente.equalsIgnoreCase(lista.Paciente) && medico.equalsIgnoreCase(lista.Medico)) {
                listaFiltrada.add(lista);
            }
        });
        return listaFiltrada;
    }

    private static List<Consulta> ordenar(List<Consulta> list) {
        boolean troca = true;
        long aux;
        while (troca) {
            troca = false;
            for (int i = 0; i < list.stream().count() - 1; i++) {

                if (list.get(i).ID > list.get(i + 1).ID) {
                    aux = list.get(i).ID;
                    list.get(i).ID = list.get(i + 1).ID;
                    list.get(i + 1).ID = aux;
                    troca = true;
                }
            }

        }
        return list;

    }
}