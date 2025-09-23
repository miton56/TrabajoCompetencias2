package com.mycompany.poryecto_competencias2.modelos;

public class Login {
    private int idLogin;
    private int idEmpleado;
    private String correo;
    private String contrasena;

    public Login(int idLogin, int idEmpleado, String correo, String contrasena) {
        this.idLogin = idLogin;
        this.idEmpleado = idEmpleado;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    // Getters y Setters
    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}

