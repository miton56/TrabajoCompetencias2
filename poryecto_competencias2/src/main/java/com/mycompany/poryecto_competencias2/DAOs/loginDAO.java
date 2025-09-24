package com.mycompany.poryecto_competencias2.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import com.mycompany.poryecto_competencias2.Controlador.Conexion;
import com.mycompany.poryecto_competencias2.modelos.Login;

public class loginDAO {

    Conexion conect = new Conexion();

    Connection con;

    public loginDAO() {
  
        this.con = this.conect.getConexion();
    }

    // Insertar un nuevo login
    public void insertarLogin(Login l) {
        try {
            String consulta = "INSERT INTO Login (ID_Empleado, CorreoUsuario, Contraseña) VALUES (?, ?, ?)";

            PreparedStatement statement = con.prepareStatement(consulta);
            statement.setInt(1, l.getIdEmpleado());
            statement.setString(2, l.getCorreo());
            statement.setString(3, l.getContrasena());

            int filas = statement.executeUpdate();

            if (filas > 0) {
                System.out.println("Login registrado correctamente");
            }

        } catch (Exception e) {
            System.out.println("Error al insertar login: " + e);
        }
    }

    // Validar login (para login.java)
    public boolean validarLogin(Login l) {
        try {
            String consulta = "SELECT * FROM Login WHERE CorreoUsuario = ? AND Contraseña = ?";

            PreparedStatement statement = con.prepareStatement(consulta);
            statement.setString(1, l.getCorreo());
            statement.setString(2, l.getContrasena());

            ResultSet rs = statement.executeQuery();

            return rs.next();

        } catch (Exception e) {
            System.out.println("Error al validar login: " + e);
            return false;
        }
    }

    public Login seleccionarLogin(Map<String, String> parametros) {
        Login login = null;
        try {
            String consulta = "SELECT * FROM Login WHERE CorreoUsuario = ?";

            PreparedStatement statement = con.prepareStatement(consulta);
            statement.setString(1, parametros.get("CorreoUsuario"));

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                login = new Login();
                login.setIdEmpleado(rs.getInt("ID_Empleado"));
                login.setCorreo(rs.getString("CorreoUsuario"));
                login.setContrasena(rs.getString("Contraseña"));
            }

        } catch (Exception e) {
            System.out.println("Error al seleccionar login: " + e);
        }
        return login;
    }
}
