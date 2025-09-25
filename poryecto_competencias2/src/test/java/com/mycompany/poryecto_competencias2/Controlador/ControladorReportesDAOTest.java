package com.mycompany.poryecto_competencias2.Controlador;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import com.mycompany.poryecto_competencias2.modelos.ReporteAtrasoModelo;
import com.mycompany.poryecto_competencias2.modelos.ReporteInasistenciaModelo;
import com.mycompany.poryecto_competencias2.modelos.ReporteSalidaModelo;

public class ControladorReportesDAOTest {

    @Test
    public void testMostrarAtrasados() {
        ControladorReportesDAO instance = new ControladorReportesDAO();
        List<ReporteAtrasoModelo> result = instance.mostrarAtrasados(
            Date.valueOf("2025-09-24"), 
            Time.valueOf("09:00:00")
        );
        assertNotNull(result);
    }

    @Test
    public void testMostrarSalidas() {
        ControladorReportesDAO instance = new ControladorReportesDAO();
        List<ReporteSalidaModelo> result = instance.mostrarSalidas(
            Date.valueOf("2025-09-24"), 
            Time.valueOf("17:00:00")
        );
        assertNotNull(result);
    }

    @Test
    public void testMostrarInasistencias() {
        ControladorReportesDAO instance = new ControladorReportesDAO();// DefaultTableModel para mostrarInasistencias
        List<ReporteInasistenciaModelo> result = instance.mostrarInasistencias(
            Date.valueOf("2025-09-24")
        );
        assertNotNull(result);
    }
}
