/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poryecto_competencias2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.*;

import com.mycompany.poryecto_competencias2.Controlador.ControladorReportesDAO;
import com.mycompany.poryecto_competencias2.DAOs.usuariosDAO;
import com.mycompany.poryecto_competencias2.modelos.usuarios;

/**
 *
 * @author Willow
 */
public class Poryecto_competencias2 {

    public static void main(String[] args) {

     ControladorReportesDAO Dao = new ControladorReportesDAO();

     LocalTime horaNew = LocalTime.now();

     LocalDate fechaNew = LocalDate.now();


     Dao.obtenerAtrasados(Date.valueOf(fechaNew), Time.valueOf(horaNew));





    }
   
}
