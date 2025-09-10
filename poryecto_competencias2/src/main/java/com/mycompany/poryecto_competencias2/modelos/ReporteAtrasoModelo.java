package com.mycompany.poryecto_competencias2.modelos;

import java.sql.Date;
import java.sql.Time;

public class ReporteAtrasoModelo {
    private String nombre;
    private String apellidos;
    private Date fecha;
    private Time horaEntrada;

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public Time getHoraEntrada() { return horaEntrada; }
    public void setHoraEntrada(Time horaEntrada) { this.horaEntrada = horaEntrada; }
}
