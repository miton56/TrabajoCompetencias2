package com.mycompany.poryecto_competencias2.modelos;

public class cargo {

    private int ID;

    private String Cargo;

    public cargo(){

    }

    public cargo(int ID, String Cargo) {
        this.ID = ID;
        this.Cargo = Cargo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    
    
}
