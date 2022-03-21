package com.ucs.dados;

import com.ucs.modelos.Consulta;

import java.util.ArrayList;
import java.util.List;

public class ListaDeConsultas {
    public static List<Consulta> _listaConsulta = new ArrayList<>();

    public static void incluirNoInicio (Consulta umaConsulta){

    }
    public static void incluirNoFim (Consulta umaConsulta){
        _listaConsulta.add(umaConsulta);
    }
    public static int tamanho (){
       return 4;
    }
    public static Consulta get(int indice){
        return new Consulta();
    }
}
