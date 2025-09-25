package com.mycompany.poryecto_competencias2.Controlador;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.mycompany.poryecto_competencias2.DAOs.ReporteDAO;
import com.mycompany.poryecto_competencias2.modelos.ReporteAtrasoModelo;
import com.mycompany.poryecto_competencias2.modelos.ReporteInasistenciaModelo;
import com.mycompany.poryecto_competencias2.modelos.ReporteSalidaModelo;

public class ControladorReportesDAO {

    private ReporteDAO reporteDAO = new ReporteDAO();

    // Mostrar atrasados
    public  List<ReporteAtrasoModelo> mostrarAtrasados(Date fecha, Time horaLimite) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Nombre", "Apellidos", "Fecha", "Hora Entrada"});

        List<ReporteAtrasoModelo> atrasados = reporteDAO.obtenerAtrasados(fecha, horaLimite);

        return atrasados;
    }

    // Mostrar salidas antes
    public List<ReporteSalidaModelo> mostrarSalidas(Date fecha, Time horaLimite) {

        List<ReporteSalidaModelo> salidas = reporteDAO.obtenerSalidasAnticipadas(fecha, horaLimite);

        return salidas;
    }

    // Mostrar inasistencias
    public List<ReporteInasistenciaModelo> mostrarInasistencias(Date fecha) {

        List<ReporteInasistenciaModelo> inasistencias = reporteDAO.obtenerInasistencias(fecha);


        return inasistencias;
    }
}
