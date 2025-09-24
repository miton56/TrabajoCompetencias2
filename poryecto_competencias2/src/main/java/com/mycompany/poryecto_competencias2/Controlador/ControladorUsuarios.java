package com.mycompany.poryecto_competencias2.Controlador;

import com.mycompany.poryecto_competencias2.DAOs.cargoEmpleadoDAO;
import com.mycompany.poryecto_competencias2.DAOs.loginDAO;
import com.mycompany.poryecto_competencias2.modelos.Login;
import com.mycompany.poryecto_competencias2.modelos.usuarios;
import com.mycompany.poryecto_competencias2.servicios.ingresoUsuariosServicio;

public class ControladorUsuarios {

    private ingresoUsuariosServicio usuariosServicio = new ingresoUsuariosServicio();

    private loginDAO logDAo = new loginDAO();

    private cargoEmpleadoDAO CargoEDao = new cargoEmpleadoDAO();

    public ControladorUsuarios(){

    }

    public void registrarUsuario(usuarios u, Login l){

        usuariosServicio.ingresarUsuarios(u, l);



    }

    public boolean comprobarUsuarios(Login l){

        return  logDAo.validarLogin(l);

    }

    public boolean comprobarAdmin(usuarios u){

        return CargoEDao.comprobarCargo(u).equals("Administrador");
    }
    
}
