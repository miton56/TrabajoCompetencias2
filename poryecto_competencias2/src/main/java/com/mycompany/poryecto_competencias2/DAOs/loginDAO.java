package com.mycompany.poryecto_competencias2.DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class loginDAO {

    String url = "jdbc:mysql://100.113.173.92:3306/empleados";
    String user = "ventas";
    String pass = "ventasMartin";

    Connection con;

    public loginDAO() {
        try {
            this.con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conectado a la BD en loginModelo");
        } catch (Exception e) {
            System.out.println("Error al conectar: " + e);
        }
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
