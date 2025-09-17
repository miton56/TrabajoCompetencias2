package com.mycompany.poryecto_competencias2.DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mycompany.poryecto_competencias2.Controlador.Conexion;

public class loginDAO {

    Conexion conect = new Conexion();

    Connection con;

    public loginDAO() {
  
        this.con = this.conect.getConexion();
    }

    // Insertar un nuevo login
    public void insertarLogin(int idEmpleado, String correo, String contrasena) {
        try {
            String consulta = "INSERT INTO Login (ID_Empleado, CorreoUsuario, Contraseña) VALUES (?, ?, ?)";

            PreparedStatement statement = con.prepareStatement(consulta);
            statement.setInt(1, idEmpleado);
            statement.setString(2, correo);
            statement.setString(3, contrasena);

            int filas = statement.executeUpdate();

            if (filas > 0) {
                System.out.println("Login registrado correctamente");
            }

        } catch (Exception e) {
            System.out.println("Error al insertar login: " + e);
        }
    }

    // Validar login (para login.java)
    public boolean validarLogin(String correo, String contrasena) {
        try {
            String consulta = "SELECT * FROM Login WHERE CorreoUsuario = ? AND Contraseña = ?";

            PreparedStatement statement = con.prepareStatement(consulta);
            statement.setString(1, correo);
            statement.setString(2, contrasena);

            ResultSet rs = statement.executeQuery();

            return rs.next();

        } catch (Exception e) {
            System.out.println("Error al validar login: " + e);
            return false;
        }
    }
}
