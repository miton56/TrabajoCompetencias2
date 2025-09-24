package com.mycompany.poryecto_competencias2.Controlador;

import java.util.HashMap;
import java.util.Map;

import com.mycompany.poryecto_competencias2.DAOs.cargoEmpleadoDAO;
import com.mycompany.poryecto_competencias2.DAOs.loginDAO;
import com.mycompany.poryecto_competencias2.DAOs.usuariosDAO;
import com.mycompany.poryecto_competencias2.modelos.Login;
import com.mycompany.poryecto_competencias2.modelos.usuarios;
import com.mycompany.poryecto_competencias2.servicios.ingresoUsuariosServicio;

public class ControladorUsuarios {

    private ingresoUsuariosServicio usuariosServicio = new ingresoUsuariosServicio();

    private loginDAO logDAo = new loginDAO();

    private cargoEmpleadoDAO CargoEDao = new cargoEmpleadoDAO();

    private usuariosDAO usuariosDAO = new usuariosDAO();

    public ControladorUsuarios(){

    }

    public void registrarUsuario(usuarios u, Login l){

        usuariosServicio.ingresarUsuarios(u, l);



    }

    public boolean comprobarUsuarios(Login l){

        return  logDAo.validarLogin(l);

    }

    public Login buscarLogin( Login l){

        Map<String, String> parametros = new HashMap<>();

        parametros.put("CorreoUsuario", String.valueOf(l.getCorreo()));

        return logDAo.seleccionarLogin(parametros);

    }

    public boolean comprobarAdmin(usuarios u){

        return CargoEDao.comprobarCargo(u).equals("Administrador");
    }

    public usuarios buscarUsuario(Login l){

        Map<String, String> parametros = new HashMap<>();

        parametros.put("ID", String.valueOf(l.getIdEmpleado()));

        return usuariosDAO.seleccionarUsuarios(parametros);

    }
    
}
