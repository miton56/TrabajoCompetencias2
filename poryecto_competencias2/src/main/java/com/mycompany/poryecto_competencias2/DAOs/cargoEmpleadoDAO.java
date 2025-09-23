package com.mycompany.poryecto_competencias2.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mycompany.poryecto_competencias2.Controlador.Conexion;
import com.mycompany.poryecto_competencias2.modelos.cargo;
import com.mycompany.poryecto_competencias2.modelos.usuarios;

public class cargoEmpleadoDAO {

    private Conexion base = new Conexion();

    private Connection con = base.getConexion();

    public cargoEmpleadoDAO(){

    }
    
    public void ingresarRelacion(usuarios u, cargo c){

        String sql = "INSERT INTO Empleado_Cargos (ID_Empleado, ID_Cargo) VALUES (?, ?)";

        try {

            PreparedStatement ps = this.con.prepareStatement(sql);

            ps.setInt(1, u.getID());

            ps.setInt(2, c.getID());

            ps.executeUpdate();

            
            
        } catch (Exception e) {
        }

    }

}
