package com.mycompany.poryecto_competencias2.Controlador;

import com.mycompany.poryecto_competencias2.modelos.ReporteAtrasoModelo;
import com.mycompany.poryecto_competencias2.modelos.ReporteInasistenciaModelo;
import com.mycompany.poryecto_competencias2.modelos.ReporteSalidaModelo;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.junit.Test;
import static org.junit.Assert.*;

public class ControladorReportesDAOTest {

    @Test
    public void testMostrarAtrasados() {
        ControladorReportesDAO instance = new ControladorReportesDAO();
        JTable tabla = new JTable(); // JTable para mostrarAtrasados
        List<ReporteAtrasoModelo> result = instance.mostrarAtrasados(
            tabla, 
            Date.valueOf("2025-09-24"), 
            Time.valueOf("09:00:00")
        );
        assertNotNull(result);
    }

    @Test
    public void testMostrarSalidas() {
        ControladorReportesDAO instance = new ControladorReportesDAO();
        DefaultTableModel modelo = new DefaultTableModel(); // DefaultTableModel para mostrarSalidas
        List<ReporteSalidaModelo> result = instance.mostrarSalidas(
            modelo, 
            Date.valueOf("2025-09-24"), 
            Time.valueOf("17:00:00")
        );
        assertNotNull(result);
    }

    @Test
    public void testMostrarInasistencias() {
        ControladorReportesDAO instance = new ControladorReportesDAO();
        DefaultTableModel modelo = new DefaultTableModel(); // DefaultTableModel para mostrarInasistencias
        List<ReporteInasistenciaModelo> result = instance.mostrarInasistencias(
            modelo, 
            Date.valueOf("2025-09-24")
        );
        assertNotNull(result);
    }
}
