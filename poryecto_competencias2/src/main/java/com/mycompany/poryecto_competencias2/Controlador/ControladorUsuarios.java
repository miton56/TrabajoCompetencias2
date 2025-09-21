package com.mycompany.poryecto_competencias2.Controlador;

import com.mycompany.poryecto_competencias2.modelos.Login;
import com.mycompany.poryecto_competencias2.modelos.usuarios;
import com.mycompany.poryecto_competencias2.servicios.ingresoUsuariosServicio;

public class ControladorUsuarios {

    private ingresoUsuariosServicio usuariosServicio = new ingresoUsuariosServicio();

    public ControladorUsuarios(){

    }

    public void registrarUsuario(usuarios u, Login l){

        usuariosServicio.ingresarUsuarios(u, l);

    }
    
}
