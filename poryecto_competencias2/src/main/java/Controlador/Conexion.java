package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private static final String URL = "jdbc:mysql://100.113.173.92:3306/empleados";
    private static final String USER = "ventas";
    private static final String PASSWORD = "ventasMartin";

    public Conexion() {
    }

    public Connection getConexion() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return conn;
    }
}

