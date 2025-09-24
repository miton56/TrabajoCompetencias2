package com.mycompany.poryecto_competencias2.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mycompany.poryecto_competencias2.Controlador.Conexion;
import com.mycompany.poryecto_competencias2.modelos.cargo;
import com.mycompany.poryecto_competencias2.modelos.usuarios;

public class cargoEmpleadoDAO {

    private Conexion base = new Conexion();

    private Connection con = base.getConexion();

    public cargoEmpleadoDAO(){

    }
    
    public boolean ingresarRelacion(usuarios u, cargo c){

        String sql = "INSERT INTO Empleado_Cargos (ID_Empleado, ID_Cargo) VALUES (?, ?)";

        try {

            PreparedStatement ps = this.con.prepareStatement(sql);

            ps.setInt(1, u.getID());

            ps.setInt(2, c.getID());

            ps.executeUpdate();

            
            return true;

        } catch (Exception e) {

            System.err.println("se ha producido un error: " + e);
            return false;
        }

    }

    public String comprobarCargo(usuarios u){

        String sql = " select c.Cargo from Cargos c  join Empleado_Cargos ec on c.ID = ec.ID_Cargo join Empleados e on e.ID = ec.ID_Empleado where e.ID = ?;";

        try {

            PreparedStatement ps = this.con.prepareStatement(sql);

            ps.setInt(1, u.getID());

            ResultSet rs =  ps.executeQuery();

            String cargo = "";

            while(rs.next()){
                
                cargo = rs.getString("Cargo");

            }

            return cargo;
            
        } catch (Exception e) {
            
            System.err.println("ha ocurrido un error: " + e);

            return "";
        }
    }

}
