/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poryecto_competencias2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycompany.poryecto_competencias2.Controlador.ControladorReportesDAO;
import com.mycompany.poryecto_competencias2.DAOs.ReporteDAO;
import com.mycompany.poryecto_competencias2.DAOs.usuariosDAO;
import com.mycompany.poryecto_competencias2.modelos.ReporteAtrasoModelo;
import com.mycompany.poryecto_competencias2.modelos.ReporteInasistenciaModelo;
import com.mycompany.poryecto_competencias2.modelos.ReporteSalidaModelo;
import com.mycompany.poryecto_competencias2.modelos.usuarios;
import com.mycompany.poryecto_competencias2.vistas.VistaLogin;
import com.mycompany.poryecto_competencias2.vistas.VistaMenuAdmin;
import com.mycompany.poryecto_competencias2.vistas.VistaMenuEmpleado;
import com.mysql.cj.util.DnsSrv;

/**
 *
 * @author Willow
 */
public class Poryecto_competencias2 {

    public static void main(String[] args) {
    
        VistaLogin vma = new VistaLogin();
        vma.setVisible(true);
        
        //VistaMenuEmpleado vme = new VistaMenuEmpleado();
        //vme.setVisible(true);
    


    }
   
}
