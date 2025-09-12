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
    public void mostrarAtrasados(javax.swing.JTable tabla, Date fecha, Time horaLimite) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Nombre", "Apellidos", "Fecha", "Hora Entrada"});

        List<ReporteAtrasoModelo> atrasados = reporteDAO.obtenerAtrasados(fecha, horaLimite);

        for (ReporteAtrasoModelo r : atrasados) {
            modelo.addRow(new Object[]{
                    r.getNombre(),
                    r.getApellidos(),
                    r.getFecha(),
                    r.getHoraEntrada()
            });
        }

        tabla.setModel(modelo);
    }

    // Mostrar salidas antes
    public void mostrarSalidas(javax.swing.JTable tabla, Date fecha, Time horaLimite) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Nombre", "Apellidos", "Fecha", "Hora Salida"});

        List<ReporteSalidaModelo> salidas = reporteDAO.obtenerSalidasAnticipadas(fecha, horaLimite);

        for (ReporteSalidaModelo r : salidas) {
            modelo.addRow(new Object[]{
                    r.getNombre(),
                    r.getApellidos(),
                    r.getFecha(),
                    r.getHoraSalida()
            });
        }

        tabla.setModel(modelo);
    }

    // Mostrar inasistencias
    public void mostrarInasistencias(javax.swing.JTable tabla, Date fecha) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Nombre", "Apellidos", "Fecha"});

        List<ReporteInasistenciaModelo> inasistencias = reporteDAO.obtenerInasistencias(fecha);

        for (ReporteInasistenciaModelo r : inasistencias) {
            modelo.addRow(new Object[]{
                    r.getNombre(),
                    r.getApellidos(),
                    r.getFecha()
            });
        }

        tabla.setModel(modelo);
    }
}
