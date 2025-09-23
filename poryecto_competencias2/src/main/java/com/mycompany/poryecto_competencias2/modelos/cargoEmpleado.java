package com.mycompany.poryecto_competencias2.modelos;

public class cargoEmpleado {

    private int ID_Empleado;

    private int ID_Cargo;

    public cargoEmpleado() {
    }

    public cargoEmpleado(int ID_Empleado, int ID_Cargo) {
        this.ID_Empleado = ID_Empleado;
        this.ID_Cargo = ID_Cargo;
    }

    public int getID_Empleado() {
        return ID_Empleado;
    }

    public void setID_Empleado(int ID_Empleado) {
        this.ID_Empleado = ID_Empleado;
    }

    public int getID_Cargo() {
        return ID_Cargo;
    }

    public void setID_Cargo(int ID_Cargo) {
        this.ID_Cargo = ID_Cargo;
    }

    
    
}
