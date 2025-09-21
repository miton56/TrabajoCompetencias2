package com.mycompany.poryecto_competencias2.Controlador;

import com.mycompany.poryecto_competencias2.DAOs.ReporteDAO;
import com.mycompany.poryecto_competencias2.modelos.ReporteAtrasoModelo;
import com.mycompany.poryecto_competencias2.modelos.ReporteSalidaModelo;
import com.mycompany.poryecto_competencias2.modelos.ReporteInasistenciaModelo;


import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class ControladorReportesDAO {

    private ReporteDAO reporteDAO = new ReporteDAO();

    // Mostrar atrasados
    public  List<ReporteAtrasoModelo> mostrarAtrasados(javax.swing.JTable tabla, Date fecha, Time horaLimite) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Nombre", "Apellidos", "Fecha", "Hora Entrada"});

        List<ReporteAtrasoModelo> atrasados = reporteDAO.obtenerAtrasados(fecha, horaLimite);

        return atrasados;
    }

    // Mostrar salidas antes
    public List<ReporteSalidaModelo> mostrarSalidas(DefaultTableModel modelo, Date fecha, Time horaLimite) {

        List<ReporteSalidaModelo> salidas = reporteDAO.obtenerSalidasAnticipadas(fecha, horaLimite);

        return salidas;
    }

    // Mostrar inasistencias
    public List<ReporteInasistenciaModelo> mostrarInasistencias(DefaultTableModel modelo, Date fecha) {

        List<ReporteInasistenciaModelo> inasistencias = reporteDAO.obtenerInasistencias(fecha);


        return inasistencias;
    }
}
