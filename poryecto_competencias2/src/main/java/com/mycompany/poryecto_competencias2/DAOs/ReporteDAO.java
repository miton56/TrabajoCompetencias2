package com.mycompany.poryecto_competencias2.DAOs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.poryecto_competencias2.Controlador.Conexion;
import com.mycompany.poryecto_competencias2.modelos.ReporteAtrasoModelo;
import com.mycompany.poryecto_competencias2.modelos.ReporteInasistenciaModelo;
import com.mycompany.poryecto_competencias2.modelos.ReporteSalidaModelo;

public class ReporteDAO {

    Conexion conect = new Conexion();

    Connection con;

    public ReporteDAO() {
      
        this.con = this.conect.getConexion();
    }

    public List<ReporteAtrasoModelo> obtenerAtrasados(Date fecha, Time horaLimite) {
        List<ReporteAtrasoModelo> lista = new ArrayList<>();
        try {
            CallableStatement cs = this.con.prepareCall("{CALL EmpleadosTarde(?, ?)}");
            cs.setDate(1, fecha);
            cs.setTime(2, horaLimite);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                ReporteAtrasoModelo rep = new ReporteAtrasoModelo();
                rep.setNombre(rs.getString("Nombre"));
                rep.setApellidos(rs.getString("Apellidos"));
                rep.setFecha(rs.getDate("Fecha"));
                rep.setHoraEntrada(rs.getTime("Hora_Entrada"));
                lista.add(rep);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener atrasados: " + e.getMessage());
        }
        return lista;
    }

    public List<ReporteSalidaModelo> obtenerSalidasAnticipadas(Date fecha, Time horaLimite) {
        List<ReporteSalidaModelo> lista = new ArrayList<>();
        try {
            CallableStatement cs = this.con.prepareCall("{CALL EmpleadosSalidaAntes(?, ?)}");
            cs.setDate(1, fecha);
            cs.setTime(2, horaLimite);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                ReporteSalidaModelo rep = new ReporteSalidaModelo();
                rep.setNombre(rs.getString("Nombre"));
                rep.setApellidos(rs.getString("Apellidos"));
                rep.setFecha(rs.getDate("Fecha"));
                rep.setHoraSalida(rs.getTime("Hora_Salida"));
                lista.add(rep);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener salidas anticipadas: " + e.getMessage());
        }
        return lista;
    }

    public List<ReporteInasistenciaModelo> obtenerInasistencias(Date fecha) {
        List<ReporteInasistenciaModelo> lista = new ArrayList<>();
        try {
            CallableStatement cs = this.con.prepareCall("{CALL EmpleadosInasistencias(?)}");
            cs.setDate(1, fecha);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                ReporteInasistenciaModelo rep = new ReporteInasistenciaModelo();
                rep.setNombre(rs.getString("Nombre"));
                rep.setApellidos(rs.getString("Apellidos"));
                lista.add(rep);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener inasistencias: " + e.getMessage());
        }
        return lista;
    }
}
