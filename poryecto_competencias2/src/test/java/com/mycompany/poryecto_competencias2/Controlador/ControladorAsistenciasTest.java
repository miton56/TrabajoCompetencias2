package com.mycompany.poryecto_competencias2.Controlador;

import com.mycompany.poryecto_competencias2.modelos.asistenciasModelo;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class ControladorAsistenciasTest {

    @Test
    public void testRegistrarEntrada() throws Exception {
        // Creamos un objeto de prueba
        asistenciasModelo asistencia = new asistenciasModelo();
        asistencia.setID_Empleado(1); // ID válido
       
        // Convertimos String a Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = sdf.parse("2025-09-24");
        asistencia.setFecha(fecha);

        // Convertimos String a Time
        Time horaEntrada = Time.valueOf("08:30:00");
        asistencia.setHora_entrada(horaEntrada);

        ControladorAsistencias controlador = new ControladorAsistencias();
        boolean resultado = controlador.registrarEntrada(asistencia);

        // Verificamos que el método retorne true
        assertTrue("La entrada debería registrarse correctamente", resultado);
    }

    @Test
    public void testRegistrarSalida() throws Exception {
        // Creamos un objeto de prueba
        asistenciasModelo asistencia = new asistenciasModelo();
        asistencia.setID_Empleado(1); // ID válido

        // Fecha
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = sdf.parse("2025-09-24");
        asistencia.setFecha(fecha);

        // Hora de salida
        Time horaSalida = Time.valueOf("17:00:00");
        asistencia.setHora_salida(horaSalida);

        ControladorAsistencias controlador = new ControladorAsistencias();
        boolean resultado = controlador.registrarSalida(asistencia);

        assertTrue("La salida debería registrarse correctamente", resultado);
    }
}
