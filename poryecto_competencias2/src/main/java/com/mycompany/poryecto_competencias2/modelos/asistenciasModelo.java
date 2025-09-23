package com.mycompany.poryecto_competencias2.modelos;

import java.sql.Time;
import java.util.Date;

public class asistenciasModelo {

    private int ID;

    private int ID_Empleado;

    private Date fecha;

    private Time hora_entrada;

    private Time hora_salida;

    public asistenciasModelo(){

    }

    public asistenciasModelo(int ID, int ID_Empleado, Date fecha, Time hora_entrada, Time hora_salida) {
        this.ID = ID;
        this.ID_Empleado = ID_Empleado;
        this.fecha = fecha;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_Empleado() {
        return ID_Empleado;
    }

    public void setID_Empleado(int ID_Empleado) {
        this.ID_Empleado = ID_Empleado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(Time hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public Time getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(Time hora_salida) {
        this.hora_salida = hora_salida;
    }




    
}
