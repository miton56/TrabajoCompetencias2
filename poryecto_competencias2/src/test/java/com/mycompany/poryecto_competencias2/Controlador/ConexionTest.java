package com.mycompany.poryecto_competencias2.Controlador;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConexionTest {
    
    private Conexion conexion;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Iniciando pruebas de Conexion...");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Finalizando pruebas de Conexion...");
    }
    
    @Before
    public void setUp() {
        conexion = new Conexion();
    }
    
    @After
    public void tearDown() {
        conexion = null;
    }

    /**
     * Test de que la conexión no sea null.
     */
    @Test
    public void testConexionNoNula() {
        Connection conn = conexion.getConexion();
        assertNotNull("La conexión no debería ser null", conn);
    }

    /**
     * Test de que la conexión esté abierta.
     */
    @Test
    public void testConexionAbierta() throws SQLException {
        Connection conn = conexion.getConexion();
        assertFalse("La conexión no debería estar cerrada", conn.isClosed());
    }
}
