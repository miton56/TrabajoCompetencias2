package com.mycompany.poryecto_competencias2.servicios;

import com.mycompany.poryecto_competencias2.DAOs.loginDAO;
import com.mycompany.poryecto_competencias2.DAOs.usuariosDAO;
import com.mycompany.poryecto_competencias2.modelos.Login;
import com.mycompany.poryecto_competencias2.modelos.usuarios;

public class ingresoUsuariosServicio {

    private loginDAO Ldao = new loginDAO();

    private usuariosDAO Udao = new usuariosDAO();

    public ingresoUsuariosServicio(){

    }
    

    public void ingresarUsuarios(usuarios u, Login l){

        Integer idNuevoUsuario = Udao.ingresarUsuario(u);

        if (idNuevoUsuario != null){

            l.setIdEmpleado(idNuevoUsuario);

            Ldao.insertarLogin(l);
            
        }

    }
    
}
