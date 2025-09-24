package com.mycompany.poryecto_competencias2.Controlador;

import com.mycompany.poryecto_competencias2.modelos.Login;
import com.mycompany.poryecto_competencias2.modelos.usuarios;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ControladorUsuariosTest {
    
    private ControladorUsuarios controlador;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Iniciando pruebas de ControladorUsuarios...");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Finalizando pruebas de ControladorUsuarios...");
    }
    
    @Before
    public void setUp() {
        controlador = new ControladorUsuarios();
    }
    
    @After
    public void tearDown() {
        // Limpiar si fuera necesario
    }
    
    // --- TESTS ---
    
    @Test
    public void testComprobarUsuariosValido() {
        Login loginValido = new Login(1, 0, "juan.perez@empresa.com", "passJuan123");
        boolean resultado = controlador.comprobarUsuarios(loginValido);
        assertTrue("El login debería ser válido", resultado);
    }

    @Test
    public void testComprobarUsuariosInvalido() {
        Login loginInvalido = new Login(0, 0, "no.existe@empresa.com", "1234");
        boolean resultado = controlador.comprobarUsuarios(loginInvalido);
        assertFalse("El login debería ser inválido", resultado);
    }
    
    @Test
    public void testComprobarAdmin() {
        // Crear usuario que sea admin según tu DB
        usuarios admin = new usuarios("Juan", "Pérez", "987654321", "12345678-9", "Av. Siempre Viva 123", "juan.perez@empresa.com", "passJuan123");
        boolean resultado = controlador.comprobarAdmin(admin);
        assertTrue("El usuario debería ser Admin", resultado);
    }
    
    @Test
    public void testBuscarLogin() {
        Login loginOriginal = new Login(1, 0, "juan.perez@empresa.com", "passJuan123");
        Login loginBuscado = controlador.buscarLogin(loginOriginal);
        assertNotNull("El login debería encontrarse en la base de datos", loginBuscado);
        assertEquals("juan.perez@empresa.com", loginBuscado.getCorreo());
    }
    
    @Test
    public void testBuscarUsuario() {
        Login loginOriginal = new Login(1, 0, "juan.perez@empresa.com", "passJuan123");
        usuarios usuarioBuscado = controlador.buscarUsuario(loginOriginal);
        assertNotNull("El usuario debería encontrarse en la base de datos", usuarioBuscado);
        assertEquals("Juan", usuarioBuscado.getNombre());
    }
    
    @Test
    public void testRegistrarUsuario() {
        // Crear un usuario temporal (no necesariamente guardarlo en DB real)
        usuarios nuevoUsuario = new usuarios("Test", "User", "999999999", "11111111-1", "Test Address", "test@correo.com", "123456");
        Login nuevoLogin = new Login(0, 0, "test@correo.com", "123456");
        // Solo llamamos al método para ver que no falle
        controlador.registrarUsuario(nuevoUsuario, nuevoLogin);
        assertTrue("Se ejecutó registrarUsuario sin errores", true);
    }
}
