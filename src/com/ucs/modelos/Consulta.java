package com.ucs.modelos;


import java.util.Date;

public class Consulta {
    public long ID;
    public String Medico;
    public String Paciente;
    public String Data;
    public String Hora;
    @Override
    public String toString(){
        return "ID: " + ID + " - Medico : " + Medico.toString() + " - Paciente : " + Paciente.toString();
    }
}
