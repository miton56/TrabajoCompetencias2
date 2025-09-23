package com.mycompany.poryecto_competencias2.Controlador;

import com.mycompany.poryecto_competencias2.DAOs.asistenciasDAO;
import com.mycompany.poryecto_competencias2.modelos.asistenciasModelo;

public class ControladorAsistencias {

    private asistenciasDAO DAO = new asistenciasDAO();

    public ControladorAsistencias(){

    }

    public boolean registrarEntrada(asistenciasModelo asistencia){

        return DAO.registrarEntrada(asistencia);

    }

    public boolean registrarSalida(asistenciasModelo asistencia){

        return DAO.registrarSalida(asistencia);
    }
    
}
