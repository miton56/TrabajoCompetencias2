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
import com.mycompany.poryecto_competencias2.vistas.VistaMenuAdmin;
import com.mycompany.poryecto_competencias2.vistas.VistaMenuEmpleado;
import com.mysql.cj.util.DnsSrv;

/**
 *
 * @author Willow
 */
public class Poryecto_competencias2 {

    public static void main(String[] args) {
    
     ReporteDAO dao = new ReporteDAO();

        // Establecer fecha y hora para pruebas
        Date fecha = Date.valueOf("2025-09-01"); // YYYY-MM-DD
        Time horaLimite = Time.valueOf("08:30:00");

        // Probar obtenerAtrasados
        System.out.println("------ Atrasados ------");
        List<ReporteAtrasoModelo> atrasos = dao.obtenerAtrasados(fecha, horaLimite);
        for (ReporteAtrasoModelo r : atrasos) {
            System.out.println(r.getNombre() + " " + r.getApellidos() + " - Entrada: " + r.getHoraEntrada() + " - Fecha: " + r.getFecha());
        }

        // Probar obtenerSalidasAnticipadas
        System.out.println("------ Salidas Anticipadas ------");
        List<ReporteSalidaModelo> salidas = dao.obtenerSalidasAnticipadas(fecha, horaLimite);
        for (ReporteSalidaModelo r : salidas) {
            System.out.println(r.getNombre() + " " + r.getApellidos() + " - Salida: " + r.getHoraSalida() + " - Fecha: " + r.getFecha());
        }

        // Probar obtenerInasistencias
        System.out.println("------ Inasistencias ------");
        List<ReporteInasistenciaModelo> inasistencias = dao.obtenerInasistencias(fecha);
        for (ReporteInasistenciaModelo r : inasistencias) {
            System.out.println(r.getNombre() + " " + r.getApellidos() + " - Fecha: " + r.getFecha());
        }
    


    }
   
}
