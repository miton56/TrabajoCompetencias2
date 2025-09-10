package com.mycompany.poryecto_competencias2.modelos;

import java.sql.Date;
import java.sql.Time;

public class ReporteSalidaModelo {
    private String nombre;
    private String apellidos;
    private Date fecha;
    private Time horaSalida;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public Time getHoraSalida() { return horaSalida; }
    public void setHoraSalida(Time horaSalida) { this.horaSalida = horaSalida; }
}
