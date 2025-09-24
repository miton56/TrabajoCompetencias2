package com.mycompany.poryecto_competencias2.DAOs;

import java.sql.Connection;
import java.sql.Date;

import com.mycompany.poryecto_competencias2.Controlador.Conexion;
import com.mycompany.poryecto_competencias2.modelos.asistenciasModelo;

public class asistenciasDAO {
    
    private Conexion base = new Conexion();

    private Connection con = base.getConexion();

    public asistenciasDAO(){

    }

    public boolean  registrarEntrada(asistenciasModelo asistencia){

        String sql = "INSERT into Asistencias (IDEmpleado, Fecha, HoraEntrada) Values (?,?,?)";

        try{

            java.sql.PreparedStatement ps = this.con.prepareStatement(sql);

            ps.setInt(1, asistencia.getID_Empleado());

            ps.setDate(2, new Date(asistencia.getFecha().getTime()));

            ps.setTime(3, asistencia.getHora_entrada());

            ps.executeUpdate();

            System.out.println("Insercion Realizada");

            return true;

        }catch(Exception e){

            System.out.println("Error al insertar: " + e.getMessage());

            return false;

        }

    

    }


    public boolean registrarSalida(asistenciasModelo asistencia){

        String sql = "UPDATE Asistencias SET hora_Salida = ? where fecha = ? and ID_Empleado = ?";

        try{

             java.sql.PreparedStatement ps = this.con.prepareStatement(sql);
                ps.setTime(1, asistencia.getHora_salida());
                ps.setDate(2, new Date(asistencia.getFecha().getTime()));
                ps.setInt(3, asistencia.getID_Empleado());

              ps.executeUpdate();

              return true;
            


        }catch(Exception e){

            System.out.println("Error al actualizar: " + e.getMessage());

            return false;

        }

    }

}

