package com.mycompany.poryecto_competencias2.Controlador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.poryecto_competencias2.modelos.ReporteAtrasoModelo;
import com.mycompany.poryecto_competencias2.modelos.ReporteInasistenciaModelo;
import com.mycompany.poryecto_competencias2.modelos.ReporteSalidaModelo;

public class ControladorReportesDAO {

    private Connection getConnection() {
        return new Conexion().getConexion();
    }

    // Obtener empleados atrasados
    public List<ReporteAtrasoModelo> obtenerAtrasados(Date fecha, Time horaLimite) {
        List<ReporteAtrasoModelo> lista = new ArrayList<>();
        try (Connection con = getConnection();
             CallableStatement cs = con.prepareCall("{CALL EmpleadosTarde(?, ?)}")) {

            cs.setDate(1, fecha);
            cs.setTime(2, horaLimite);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                ReporteAtrasoModelo reporte = new ReporteAtrasoModelo();
                reporte.setNombre(rs.getString("Nombre"));
                reporte.setApellidos(rs.getString("Apellidos"));
                reporte.setFecha(rs.getDate("Fecha"));
                reporte.setHoraEntrada(rs.getTime("Hora_Entrada"));
                lista.add(reporte);
            }

        } catch (Exception e) {
            System.out.println("Error al obtener atrasados: " + e.getMessage());
        }
        return lista;
    }

    // Obtener empleados con salida anticipada
    public List<ReporteSalidaModelo> obtenerSalidasAnticipadas(Date fecha, Time horaLimite) {
        List<ReporteSalidaModelo> lista = new ArrayList<>();
        try (Connection con = getConnection();
             CallableStatement cs = con.prepareCall("{CALL EmpleadosSalidaAntes(?, ?)}")) {

            cs.setDate(1, fecha);
            cs.setTime(2, horaLimite);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                ReporteSalidaModelo reporte = new ReporteSalidaModelo();
                reporte.setNombre(rs.getString("Nombre"));
                reporte.setApellidos(rs.getString("Apellidos"));
                reporte.setFecha(rs.getDate("Fecha"));
                reporte.setHoraSalida(rs.getTime("Hora_Salida"));
                lista.add(reporte);
            }

        } catch (Exception e) {
            System.out.println("Error al obtener salidas anticipadas: " + e.getMessage());
        }
        return lista;
    }

    // Obtener empleados inasistentes
    public List<ReporteInasistenciaModelo> obtenerInasistencias(Date fecha) {
        List<ReporteInasistenciaModelo> lista = new ArrayList<>();
        try (Connection con = getConnection();
             CallableStatement cs = con.prepareCall("{CALL EmpleadosInasistentes(?)}")) {

            cs.setDate(1, fecha);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                ReporteInasistenciaModelo reporte = new ReporteInasistenciaModelo();
                reporte.setNombre(rs.getString("Nombre"));
                reporte.setApellidos(rs.getString("Apellidos"));
                reporte.setFecha(rs.getDate("Fecha"));
                lista.add(reporte);
            }

        } catch (Exception e) {
            System.out.println("Error al obtener inasistencias: " + e.getMessage());
        }
        return lista;
    }
}
