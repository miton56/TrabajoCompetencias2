package com.mycompany.poryecto_competencias2.modelos;



public class usuarios {

    int ID;
    
    String Nombre;

    String Apellidos;

    String Telefono;

    String Rut;

    String Direccion;

    String correo;

    String contrasenia;

    public usuarios() {
    }

    public usuarios(String Nombre, String Apellidos, String Telefono, String Rut, String Direccion, String Correo, String Contrasenia) {
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Telefono = Telefono;
        this.Rut = Rut;
        this.Direccion = Direccion;
        this.correo = Correo;
        this.contrasenia = Contrasenia;
        
    }

    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return this.Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getTelefono() {
        return this.Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getRut() {
        return this.Rut;
    }

    public void setRut(String Rut) {
        this.Rut = Rut;
    }

    public String getDireccion() {
        return this.Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
    public void setID(int id){
        this.ID = id;
    }

    public int getID(){
        return this.ID;
    }

      public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String Correo) {
        this.correo = Correo;
    }

      public String getContrasenia() {
        return this.contrasenia;
    }

    public void setContrasenia(String Contrasenia) {
        this.contrasenia = Contrasenia;
    }

   




}
